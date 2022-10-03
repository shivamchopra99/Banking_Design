package com.Banking.bankingservice.service;


import com.Banking.bankingservice.action.LoanOperationActionImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrchestratorServiceImpl implements OrchestratorService {
    @Autowired
    LoanOperationActionImpl loanOperationAction;
    // it will split the input string according to the spaces and will call loanOperationAction for different actions according to balance, payment and loan
    @Override
    public void performOperation(List<String> lines) {
        for (String line : lines) {
            String[] input = line.split("\\s+");
            loanOperationAction.performAction(input);
        }
    }

}
