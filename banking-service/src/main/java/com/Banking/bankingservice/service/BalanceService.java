package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Balance;
import com.Banking.bankingservice.model.Loan;
import com.Banking.bankingservice.model.Payment;
import javafx.util.Pair;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public interface BalanceService {
    Balance performBalanceAction(String[] input);

   String getBalanceWithRemainingInstallments(Map<Pair<String, String>, Loan> _loanMap, Map<Pair<String, String>, Payment> _paymentMap, Balance balance);
}
