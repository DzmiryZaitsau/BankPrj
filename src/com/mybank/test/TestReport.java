package com.mybank.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mybank.domain.*;
import com.mybank.report.*;

public class TestReport {


    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        initializeCustomers();

        // run the customer report
        Injector injector = Guice.createInjector(new MyModule());
        CustomerReport report = injector.getInstance(CustomerReport.class);
        report.generateReport();
    }

    private static void initializeCustomers() {
        Injector injector = Guice.createInjector(new MyModule());
        Customer customer = injector.getInstance(Customer.class);
        SavingsAccount savingsAccount = injector.getInstance(SavingsAccount.class);
        CheckingAccount checkingAccount = injector.getInstance(CheckingAccount.class);


        // Create several customers and their accounts
        Bank.addCustomer("Jane", "Simms");
        customer = Bank.getCustomer(0);
        customer.addAccount(savingsAccount);
        savingsAccount.setBalance(500);
        savingsAccount.setInterestRate(0.05);
        customer.addAccount(new CheckingAccount(200.00, 400.00));
        checkingAccount.setBalance(200);
        checkingAccount.setOverdraftAmount(400);

        Bank.addCustomer("Owen", "Bryant");
        customer = Bank.getCustomer(1);
        customer.addAccount(checkingAccount);
        checkingAccount.setBalance(200);

        Bank.addCustomer("Tim", "Soley");
        customer = Bank.getCustomer(2);
        customer.addAccount(savingsAccount);
        savingsAccount.setBalance(1500);
        savingsAccount.setInterestRate(0.05);
        customer.addAccount(checkingAccount);
        checkingAccount.setBalance(200);

        Bank.addCustomer("Maria", "Soley");
        customer = Bank.getCustomer(3);
        // Maria and Tim have a shared checking account
        customer.addAccount(Bank.getCustomer(2).getAccount(1));
        customer.addAccount(new SavingsAccount(150.00, 0.05));
        savingsAccount.setBalance(150);
        savingsAccount.setInterestRate(0.05);
    }
}
