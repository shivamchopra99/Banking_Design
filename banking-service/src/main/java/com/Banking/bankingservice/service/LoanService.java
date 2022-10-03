package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Loan;
import org.springframework.stereotype.Component;

@Component
public interface LoanService {
    Loan performLoanOperation(String[] input);
}
