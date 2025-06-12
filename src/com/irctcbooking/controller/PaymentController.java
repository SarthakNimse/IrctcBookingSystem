package com.irctcbooking.controller;

import com.irctcbooking.exception.InvalidPaymentMethodException;
import com.irctcbooking.exception.PaymentFailedException;
import com.irctcbooking.service.PaymentService;

import java.util.Scanner;

public class PaymentController {

    private PaymentService paymentService = new PaymentService();
    private Scanner sc = new Scanner(System.in);

    public void handlePaymentOperations() {
        int option;
        do {
            System.out.println("\n---- Payment Management ----");
            System.out.println("1. Make Payment");
            System.out.println("2. View Payment Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        paymentService.acceptPaymentInfo();
                        break;
                    case 2:
                        paymentService.displayPaymentInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (PaymentFailedException | InvalidPaymentMethodException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
