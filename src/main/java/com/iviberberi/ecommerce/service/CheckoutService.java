package com.iviberberi.ecommerce.service;

import com.iviberberi.ecommerce.dto.Purchase;
import com.iviberberi.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
