package com.lab.payment;

public class CreditCardPaymentProvider implements PaymentStrategy {
    @Override
    public void process(double amount, String accountId) {
        System.out.println("Processing Credit Card charge of $" + amount + " for " + accountId);
    }

    @Override
    public String getProviderName() {
        return "CREDIT_CARD";
    }
}