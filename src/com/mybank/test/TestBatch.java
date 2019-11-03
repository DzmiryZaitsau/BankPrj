package com.mybank.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mybank.domain.*;
import com.mybank.report.*;
import com.mybank.batch.*;

public class TestBatch {
    
    public static void main(String[] args) {



        Bank     bank = Bank.getInstance();
        initializeCustomers(bank);

        Injector injector = Guice.createInjector(new MyModule());
        CustomerReport customerReport = injector.getInstance(CustomerReport.class);
        customerReport.generateReport();
        
        AccumulateSavingsBatch job = injector.getInstance(AccumulateSavingsBatch.class);
        job.setBank(bank);
        job.doBatch();
        System.out.println();
        System.out.println("ACCUMULATE SAVINGS BATCH EXECUTED");
        System.out.println();
        
        // run the customer report again
        customerReport.generateReport();
    }
    
    private static void initializeCustomers(Bank bank) {
        Injector injector = Guice.createInjector(new MyModule());
        SavingsAccount savingsAccount = injector.getInstance(SavingsAccount.class);
        CheckingAccount checkingAccount = injector.getInstance(CheckingAccount.class);

        Customer customer;
        
        // Create several customers and their accounts
        Bank.addCustomer("Jane", "Simms");
        customer = Bank.getCustomer(0);
        customer.addAccount(savingsAccount);
        savingsAccount.setBalance(500);
        savingsAccount.setInterestRate(0.05);
        customer.addAccount(checkingAccount);
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
        customer.addAccount(savingsAccount);
        savingsAccount.setBalance(150);
        savingsAccount.setInterestRate(0.05);
    }
}
