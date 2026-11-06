package com.lab.payment;

public class MobileMoneyPaymentProvider implements PaymentStrategy {
    @Override
    public void process(double amount, String accountId) {
        System.out.println("Processing M-Pesa transfer of $" + amount + " for " + accountId);
    }

    @Override
    public String getProviderName() {
        return "MOBILE_MONEY";
    }
}