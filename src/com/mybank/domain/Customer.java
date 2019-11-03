package com.mybank.domain;

import com.google.inject.Inject;

public class Customer {

  private String firstName;

  private String lastName;

  private Account[] accounts;
  private int numberOfAccounts;
  public Customer() {}


  public Customer(String f, String l) {
    firstName = f;
    lastName = l;
    accounts = new Account[10];
    numberOfAccounts = 0;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void addAccount(Account acct) {
    int i = numberOfAccounts++;
    accounts[i] = acct;
  }

  public int getNumOfAccounts() {
    return numberOfAccounts;
  }

  public Account getAccount(int account_index) {
    return accounts[account_index];
  }
}
