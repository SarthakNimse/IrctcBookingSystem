package com.irctcbooking.controller;

import com.irctcbooking.exception.AdminAccessDeniedException;
import com.irctcbooking.exception.AdminNotFoundException;
import com.irctcbooking.service.AdminService;

import java.util.Scanner;

public class AdminController {

    private AdminService adminService = new AdminService();
    private Scanner sc = new Scanner(System.in);

    public void handleAdminOperations() {
        int option;
        do {
            System.out.println("\n---- Admin Management ----");
            System.out.println("1. Add Admin");
            System.out.println("2. View Admin Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        adminService.acceptAdminInfo();
                        break;
                    case 2:
                        adminService.displayAdminInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (AdminNotFoundException | AdminAccessDeniedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
