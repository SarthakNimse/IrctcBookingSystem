package com.irctcbooking.controller;

import com.irctcbooking.exception.InvalidUserDetailsException;
import com.irctcbooking.exception.UserNotFoundException;
import com.irctcbooking.service.UserService;

import java.util.Scanner;

public class UserController {

    private UserService userService = new UserService();
    private Scanner sc = new Scanner(System.in);

    public void handleUserOperations() {
        int option;
        do {
            System.out.println("\n---- User Management ----");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        userService.acceptUserInfo();
                        break;
                    case 2:
                        userService.displayUserInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (UserNotFoundException | InvalidUserDetailsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
