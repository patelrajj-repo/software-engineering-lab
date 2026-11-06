package com.lab.payment;

public interface PaymentStrategy {
    void process(double amount, String accountId);
    String getProviderName();
}