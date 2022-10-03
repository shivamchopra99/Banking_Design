package com.Banking.bankingservice.service;

import com.Banking.bankingservice.model.Balance;
import com.Banking.bankingservice.model.Loan;
import com.Banking.bankingservice.model.Payment;
import javafx.util.Pair;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.NoSuchElementException;

import static com.Banking.bankingservice.constant.Constants.balanceLength;
import static com.Banking.bankingservice.constant.Constants.MonthsInSingleYear;
@Service
public class BalanceServiceImpl implements BalanceService {
    //function for setting the balance model of the input
    @Override
    public Balance performBalanceAction(String[] input) {
        if (input.length != balanceLength + 1) {
            throw new IllegalArgumentException("Invalid Input");
        }

        Balance balance;
        try {
            balance = new Balance(input[1], input[2], Integer.parseInt(input[3]));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Input");
        }
        return balance;
    }
 // function for getting bankName, borrowerName, totalBalance and Remaining Installments
    @Override
    public String getBalanceWithRemainingInstallments(Map<Pair<String,String>,Loan> _loanMap, Map<Pair<String,String>,Payment>_paymentMap, Balance balance) {
        Loan loanOnBorrowerName = loanOnBorrowerName(_loanMap,balance);
        int calculatedInterest = getInterest(loanOnBorrowerName);
        int monthlyEmiInstallment = getEquatedMonthlyInstallment(loanOnBorrowerName,calculatedInterest);
        int lumpSumAmountPaid = lumpSumAmountPaidBeforeEmi(_paymentMap,balance);
        int calculatedBalance = getBalance(monthlyEmiInstallment, lumpSumAmountPaid,balance.getEmiNo());
        int totalAmountToPay = calculatedInterest + loanOnBorrowerName.getPrincipal();
        int totalBalance = Math.min(calculatedBalance, totalAmountToPay);
        int remainingInstallments = getRemainingInstallments(loanOnBorrowerName,balance.getEmiNo(), monthlyEmiInstallment, lumpSumAmountPaid);

        if (remainingInstallments * monthlyEmiInstallment + totalBalance < totalAmountToPay)
        {
            remainingInstallments++;
        }


        return balance.getBankName() + " " + balance.getBorrowerName() + " " + Integer.toString(totalBalance) + " " +Integer.toString(remainingInstallments);




    }
  // function for getting loan on borrowers name
    public Loan loanOnBorrowerName(Map<Pair<String,String>,Loan> _loanMap,Balance balance){
        Pair<String,String>input = new Pair<>(balance.getBankName(),balance.getBorrowerName());
        if(_loanMap.containsKey(input)){
            return _loanMap.get(input);
        }else{
            throw new NoSuchElementException("No loan taken");
        }
    }
   // function for getting lumpSumAmount paid by the borrower
    public Integer lumpSumAmountPaidBeforeEmi(Map<Pair<String,String>,Payment>_paymentMap,Balance balance){
        Pair<String,String>input = new Pair<>(balance.getBankName(),balance.getBorrowerName());
        if(_paymentMap.containsKey(input)){
            Payment payment = _paymentMap.get(input);
            if(payment.getEmiNo()<=balance.getEmiNo()){
                return payment.getLumpSumAmount();
            }
        }
        return 0;
    }
  //total interest on borrowers loan
    public Integer getInterest(Loan loanOnBorrowerName) {
        return (int) Math.ceil((double) (((loanOnBorrowerName.getRateOfInterest() * loanOnBorrowerName.getPrincipal()) / 100) * loanOnBorrowerName.getNoOfYears()));
    }
   //monthly emi of the borrower
    public int getEquatedMonthlyInstallment(Loan loanOnBorrowerName, Integer calculatedInterest) {

        float noOfMonths = loanOnBorrowerName.getNoOfYears() * MonthsInSingleYear;
        return (int) Math.ceil((loanOnBorrowerName.getPrincipal() + calculatedInterest) / noOfMonths);
    }

    public int getBalance(int monthlyEmiInstallment, int lumpsumAmountPaid,int emiNo)
    {
        return (monthlyEmiInstallment * emiNo) + lumpsumAmountPaid;
    }

    public int getRemainingInstallments(Loan loan, int emiNo,int monthlyEmiInstallment, int lumpSumAmountPaid)
    {
        float montlyInstallMent = monthlyEmiInstallment;
        int lumpSumPaidForMonths = (int)Math.round(lumpSumAmountPaid / montlyInstallMent);
        return (loan.getNoOfYears() * MonthsInSingleYear - emiNo) - lumpSumPaidForMonths;
    }

}
