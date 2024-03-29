package com.mybank.batch;

import com.google.inject.Inject;
import com.mybank.domain.*;

public class AccumulateSavingsBatch {
    
    private Bank bank;
    public AccumulateSavingsBatch() {
    }
    
    public Bank getBank() {
        return bank;
    }
    
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
    public void doBatch() {
        
        // For each customer...
        for ( int cust_idx = 0;
        cust_idx < Bank.getNumOfCustomers();
        cust_idx++ ) {
            Customer customer = Bank.getCustomer(cust_idx);
            
            // For each account for this customer...
            for ( int acct_idx = 0;
            acct_idx < customer.getNumOfAccounts();
            acct_idx++ ) {
                Account account = customer.getAccount(acct_idx);
                String  account_type = "";
                
                // Determine the account type
                if ( account instanceof SavingsAccount ) {
                    SavingsAccount savings = (SavingsAccount) account;
                    savings.accumulateInterest();
                } else {
                    // ignore all other account types
                }
            }
        }
    }
}
