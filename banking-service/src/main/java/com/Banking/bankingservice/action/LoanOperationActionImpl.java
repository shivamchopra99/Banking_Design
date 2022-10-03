package com.Banking.bankingservice.action;

import com.Banking.bankingservice.model.Balance;
import com.Banking.bankingservice.model.Loan;
import com.Banking.bankingservice.model.Payment;
import com.Banking.bankingservice.service.BalanceService;
import com.Banking.bankingservice.service.LoanService;
import com.Banking.bankingservice.service.PaymentService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.Banking.bankingservice.constant.Constants.balance;
import static com.Banking.bankingservice.constant.Constants.payment;
import static com.Banking.bankingservice.constant.Constants.loan;


import java.util.*;

@Component
public class LoanOperationActionImpl implements LoanOperationAction {
    @Autowired
    LoanService loanService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    BalanceService balanceService;



    Map<Pair<String,String>,Loan> _loanMap;
    Map<Pair<String,String>,Payment>_paymentMap;

    public LoanOperationActionImpl() {
        _loanMap = new HashMap<>();
        _paymentMap = new HashMap<>();
    }
    // from here we filter which action to perform and calls different services which has bussiness logic for loan,payment and balance
    @Override
    public void performAction(String[] input) {
        if (input.length == 0) throw new NullPointerException("Input is Invalid");
        String firstWord = input[0];
        if (Objects.equals(firstWord, loan)) {
           Loan loan = loanService.performLoanOperation(input);
           Pair<String,String>unique = new Pair<>(loan.getBankName(),loan.getBorrowerName());
           _loanMap.put(unique,loan);
        } else if (Objects.equals(firstWord, payment)) {
            Payment payment = paymentService.performPaymentOperation(input);
            Pair<String,String>unique = new Pair<>(payment.getBankName(),payment.getBorrowerName());
            _paymentMap.put(unique,payment);

        } else if (Objects.equals(firstWord, balance)) {
            Balance balance = balanceService.performBalanceAction(input);
            String output = balanceService.getBalanceWithRemainingInstallments(_loanMap,_paymentMap,balance);
            System.out.println(output);
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
