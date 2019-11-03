package com.mybank.domain;


public class SavingsAccount extends Account {

    private double interestRate;
    public SavingsAccount() {}

    public SavingsAccount(double initBalance, double interestRate) {
        super(initBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void accumulateInterest() {
        balance += (balance * (interestRate / 12));
    }
}
