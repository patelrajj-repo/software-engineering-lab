package com.lab.payment;

public class SmsNotificationService implements NotificationService {
    @Override
    public void sendNotification(String accountId, String message) {
        System.out.println("Sending SMS to " + accountId + ": " + message);
    }
}