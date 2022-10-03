package com.Banking.bankingservice.model;

public class Loan {


    private String bankName;
    private String borrowerName;
    private Integer principal;
    private Integer noOfYears;
    private Integer rateOfInterest;

    public Loan(){

    }
    //Constructor
    public Loan(String bankName, String borrowerName, Integer principal, Integer noOfYears, Integer rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    public String getBankName() {
        return bankName;
    }


    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public Integer getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Integer rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Integer getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(Integer noOfYears) {
        this.noOfYears = noOfYears;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
