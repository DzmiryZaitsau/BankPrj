package com.mybank.domain;

public class Bank {
    private static Bank _instance = null;
    private static Customer[] customers;
    private static int numberOfCustomers;

    private Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public static void addCustomer(String f, String l) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(f, l);
    }

    public static int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public static Customer getCustomer(int customer_index) {
        return customers[customer_index];
    }
    public synchronized static Bank getInstance() {
        if (_instance == null)
            _instance = new Bank();
        return _instance;
    }


}
