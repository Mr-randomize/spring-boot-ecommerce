package com.iviberberi.ecommerce.service;

import com.iviberberi.ecommerce.dto.PaymentInfo;
import com.iviberberi.ecommerce.dto.Purchase;
import com.iviberberi.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
