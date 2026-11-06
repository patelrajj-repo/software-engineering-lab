package com.lab.payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentProcessor {
    private final Map<String, PaymentStrategy> providers = new HashMap<>();
    private final NotificationService notificationService;

    // Dependency Injection via Constructor
    public PaymentProcessor(List<PaymentStrategy> strategyList, NotificationService notificationService) {
        this.notificationService = notificationService;
        for (PaymentStrategy strategy : strategyList) {
            this.providers.put(strategy.getProviderName().toUpperCase(), strategy);
        }
    }

    public void executePayment(String paymentType, double amount, String accountId) {
        if (amount <= 0 || accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Invalid payment parameters.");
        }

        PaymentStrategy provider = providers.get(paymentType.toUpperCase());
        if (provider == null) {
            throw new UnsupportedOperationException("Unsupported payment type: " + paymentType);
        }

        provider.process(amount, accountId);
        notificationService.sendNotification(accountId, "Payment of $" + amount + " processed via " + paymentType);
    }
}