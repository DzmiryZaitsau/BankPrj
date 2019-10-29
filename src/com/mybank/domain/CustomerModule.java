package com.mybank.domain;

import com.google.inject.AbstractModule;

public class CustomerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Customer.class);
    }
}
