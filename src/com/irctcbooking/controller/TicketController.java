package com.irctcbooking.controller;

import com.irctcbooking.exception.SeatsNotAvailableException;
import com.irctcbooking.exception.TicketNotFoundException;
import com.irctcbooking.service.TicketService;

import java.util.Scanner;

public class TicketController {

    private TicketService ticketService = new TicketService();
    private Scanner sc = new Scanner(System.in);

    public void handleTicketOperations() {
        int option;
        do {
            System.out.println("\n---- Ticket Management ----");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        ticketService.acceptTicketInfo();
                        break;
                    case 2:
                        ticketService.displayTicketInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (TicketNotFoundException | SeatsNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
