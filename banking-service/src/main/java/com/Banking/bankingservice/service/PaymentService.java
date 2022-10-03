package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentService {

    Payment performPaymentOperation(String[] input);
}
