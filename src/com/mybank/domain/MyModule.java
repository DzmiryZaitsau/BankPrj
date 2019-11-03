package com.mybank.domain;

import com.google.inject.AbstractModule;
import com.mybank.batch.AccumulateSavingsBatch;
import com.mybank.report.CustomerReport;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(Account.class);
        bind(CheckingAccount.class);
        bind(SavingsAccount.class);
        bind(CustomerReport.class);
        bind(AccumulateSavingsBatch.class);
    }
}
