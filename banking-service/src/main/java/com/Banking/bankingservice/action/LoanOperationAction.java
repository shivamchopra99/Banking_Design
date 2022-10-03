package com.Banking.bankingservice.action;

import org.springframework.stereotype.Component;

@Component
public interface LoanOperationAction {
    void performAction(String[] input);
}
