package com.iviberberi.ecommerce.service;

import com.iviberberi.ecommerce.dao.CustomerRepository;
import com.iviberberi.ecommerce.dto.Purchase;
import com.iviberberi.ecommerce.dto.PurchaseResponse;
import com.iviberberi.ecommerce.entity.Customer;
import com.iviberberi.ecommerce.entity.Order;
import com.iviberberi.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with Order Items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with both addresses
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();

        // check if this is an existing customer
        String theEmail = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if(customerFromDB != null){
            customer = customerFromDB;
        }

        customer.add(order);

        //save to database
        customerRepository.save(customer);

        // return a response

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
