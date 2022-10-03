package com.Banking.bankingservice.model;

public class Balance {
    private String bankName;
    private String borrowerName;
    private Integer emiNo;

    public Balance() {

    }
    //Constructor
    public Balance(String bankName, String borrowerName, Integer emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNo = emiNo;
    }

    public Integer getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(Integer emiNo) {
        this.emiNo = emiNo;
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
