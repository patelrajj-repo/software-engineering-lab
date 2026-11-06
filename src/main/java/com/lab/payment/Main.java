package com.lab.payment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPaymentProvider();
        PaymentStrategy mobileMoney = new MobileMoneyPaymentProvider();
        NotificationService smsService = new SmsNotificationService();

        PaymentProcessor processor = new PaymentProcessor(
            List.of(creditCard, mobileMoney),
            smsService
        );

        processor.executePayment("CREDIT_CARD", 150.00, "ACC-1001");
        processor.executePayment("MOBILE_MONEY", 75.50, "ACC-2002");
    }
}