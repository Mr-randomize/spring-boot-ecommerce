package com.iviberberi.ecommerce.dto;

import com.iviberberi.ecommerce.entity.Address;
import com.iviberberi.ecommerce.entity.Customer;
import com.iviberberi.ecommerce.entity.Order;
import com.iviberberi.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
