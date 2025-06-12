package com.irctcbooking.controller;

import com.irctcbooking.exception.BookingCancellationException;
import com.irctcbooking.exception.BookingNotFoundException;
import com.irctcbooking.service.BookingHistoryService;

import java.util.Scanner;

public class BookingHistoryController {

    private BookingHistoryService bookingService = new BookingHistoryService();
    private Scanner sc = new Scanner(System.in);

    public void handleBookingOperations() {
        int option;
        do {
            System.out.println("\n---- Booking Management ----");
            System.out.println("1. Add Booking");
            System.out.println("2. View Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        bookingService.acceptBookingHistoryInfo();
                        break;
                    case 2:
                        bookingService.displayBookingHistoryInfo();
                        break;
                    case 3:
                        bookingService.cancelBooking();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (BookingNotFoundException | BookingCancellationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
