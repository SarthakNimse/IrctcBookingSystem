package com.irctcbooking.controller;

import com.irctcbooking.exception.NotificationDeliveryException;
import com.irctcbooking.exception.NotificationNotFoundException;
import com.irctcbooking.service.NotificationAlertService;

import java.util.Scanner;

public class NotificationAlertController {

    private NotificationAlertService notificationService = new NotificationAlertService();
    private Scanner sc = new Scanner(System.in);

    public void handleNotificationOperations() {
        int option;
        do {
            System.out.println("\n---- Notification Management ----");
            System.out.println("1. Send Notification");
            System.out.println("2. View Notification");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        notificationService.acceptNotificationAlertInfo();
                        break;
                    case 2:
                        notificationService.displayNotificationAlertInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (NotificationNotFoundException | NotificationDeliveryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}

