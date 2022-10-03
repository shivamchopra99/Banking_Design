package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Payment;
import org.springframework.stereotype.Service;


import static com.Banking.bankingservice.constant.Constants.paymentLength;

@Service
public class PaymentServiceImpl implements PaymentService {
    //function for setting the payment model of the input
    @Override
    public Payment performPaymentOperation(String[] input) {
        if (input.length != paymentLength + 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        Payment payment;
        try {
            payment = new Payment(input[1], input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]));

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Input");
        }
        return payment;

    }
}
