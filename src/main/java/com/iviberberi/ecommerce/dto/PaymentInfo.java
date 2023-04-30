package com.iviberberi.ecommerce.dto;

import lombok.Data;

@Data
public class PaymentInfo {

    private int amount; //Use the smallest denomination ex. Cent
    private String currency;
    private String receiptEmail;
}
