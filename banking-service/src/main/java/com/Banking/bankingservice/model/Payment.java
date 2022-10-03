package com.Banking.bankingservice.model;

public class Payment {

    private String bankName;
    private String borrowerName;
    private Integer lumpSumAmount;
    private Integer emiNo;

    public Payment(){

    }
    //Constructor
    public Payment(String bankName, String borrowerName, Integer lumpSumAmount, Integer emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }

    public Integer getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(Integer emiNo) {
        this.emiNo = emiNo;
    }

    public Integer getLumpSumAmount() {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(Integer lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
