package com.irctcbooking.service;

import com.irctcbooking.exception.NotificationDeliveryException;
import com.irctcbooking.exception.NotificationNotFoundException;
import com.irctcbooking.model.NotificationAlert;

import java.util.HashMap;
import java.util.Scanner;

public class NotificationAlertService {

    private HashMap<Integer, NotificationAlert> notificationalerts = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void acceptNotificationAlertInfo() {
        NotificationAlert notificationalert = new NotificationAlert();

        System.out.println("Enter Notification Alert ID: ");
        int notificationAlertId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your Notification Type (EMAIL/SMS): ");
        String type = sc.nextLine();

        if (!isValidNotificationType(type)) {
            throw new NotificationDeliveryException("Invalid Notification Type: " + type + ". Please use EMAIL Or SMS");
        }

        System.out.println("Enter Notification Message: ");
        String message = sc.nextLine();

        System.out.println("Enter Date & Time: ");
        String dateTime = sc.nextLine();

        notificationalert.setNotificationAlertId(notificationAlertId);
        notificationalert.setType(type);
        notificationalert.setMessage(message);
        notificationalert.setDateTime(dateTime);
        notificationalerts.put(notificationAlertId, notificationalert);

        System.out.println(" Notification Alert information saved successfully!");
    }

    public void displayNotificationAlertInfo() {
        System.out.println("Enter Notification Alert ID to fetch details: ");
        int notificationAlertId = Integer.parseInt(sc.nextLine());

        if (!notificationalerts.containsKey(notificationAlertId)) {
            throw new NotificationNotFoundException("Notification with ID " + notificationAlertId + " not found!");
        }

        NotificationAlert notificationalert = notificationalerts.get(notificationAlertId);
        System.out.println("Notification Details: " + notificationalert);
    }

    private boolean isValidNotificationType(String type) {
        return type.equalsIgnoreCase("EMAIL") || type.equalsIgnoreCase("SMS");
    }
}

