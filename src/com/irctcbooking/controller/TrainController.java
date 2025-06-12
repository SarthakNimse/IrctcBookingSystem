package com.irctcbooking.controller;

import com.irctcbooking.exception.TrainNotFoundException;
import com.irctcbooking.service.TrainService;

import java.util.Scanner;

public class TrainController {

    private TrainService trainService = new TrainService();
    private Scanner sc = new Scanner(System.in);

    public void handleTrainOperations() {
        int option;
        do {
            System.out.println("\n---- Train Management ----");
            System.out.println("1. Add Train");
            System.out.println("2. View Train");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        trainService.acceptTrainInfo();
                        break;
                    case 2:
                        trainService.displayTrainInfo();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (TrainNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
