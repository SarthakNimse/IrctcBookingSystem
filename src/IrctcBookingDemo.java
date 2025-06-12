package com.irctcbooking;

import com.irctcbooking.controller.*;
import java.util.Scanner;

public class IrctcBookingDemo {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        UserController userController = new UserController();
        TrainController trainController = new TrainController();
        TicketController ticketController = new TicketController();
        PaymentController paymentController = new PaymentController();
        NotificationAlertController notificationController = new NotificationAlertController();
        BookingHistoryController bookingHistoryController = new BookingHistoryController();
        AdminController adminController = new AdminController();

        int option = 0;
        do {
            System.out.println("\n------------------------ Welcome to IRCTC Booking System ------------------------");
            System.out.println("Please choose the option you want to process: ");
            System.out.println("1. User Management");
            System.out.println("2. Train Management");
            System.out.println("3. Ticket Booking");
            System.out.println("4. Payment Management");
            System.out.println("5. Notification Alerts");
            System.out.println("6. Booking History");
            System.out.println("7. Admin Management");
            System.out.println("0: Exit");
            System.out.print("Enter your choice: ");

            try {
                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        userController.handleUserOperations();
                        break;
                    case 2:
                        trainController.handleTrainOperations();
                        break;
                    case 3:
                        ticketController.handleTicketOperations();
                        break;
                    case 4:
                        paymentController.handlePaymentOperations();
                        break;
                    case 5:
                        notificationController.handleNotificationOperations();
                        break;
                    case 6:
                        bookingHistoryController.handleBookingOperations();
                        break;
                    case 7:
                        adminController.handleAdminOperations();
                        break;
                    case 0:
                        System.out.println("THANK YOU FOR USING THE IRCTC BOOKING SYSTEM! Safe Travels!");
                        break;
                    default:
                        System.out.println("Invalid option! Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }

        } while (option != 0);
    }
}
