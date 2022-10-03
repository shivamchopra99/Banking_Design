package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Loan;
import org.springframework.stereotype.Service;
import static com.Banking.bankingservice.constant.Constants.loanLength;

@Service
public class LoanServiceImpl implements LoanService{
    //function for setting the loan model of the input
    @Override
    public Loan performLoanOperation(String[] input){
        Loan loan;
        loan = new Loan();
        if(input.length!=loanLength+1) {
            try {
                throw new Exception();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
                loan.setBankName(input[1]);
                loan.setBorrowerName(input[2]);
                loan.setPrincipal(Integer.parseInt(input[3]));
                loan.setNoOfYears(Integer.parseInt(input[4]));
                loan.setRateOfInterest(Integer.parseInt(input[5]));
            }
        catch(Exception e) {
         throw new IllegalArgumentException("Invalid input");
        }
       return loan;
    };
}
