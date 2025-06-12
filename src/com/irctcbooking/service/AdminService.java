package com.irctcbooking.service;

import com.irctcbooking.exception.AdminNotFoundException;
import com.irctcbooking.model.Admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminService {

    private HashMap<Integer, Admin> admins = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void acceptAdminInfo() {
        try {
            Admin admin = new Admin();

            System.out.print("Enter Admin ID: ");
            int adminId;
            try {
                adminId = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Admin ID. ");
                return;
            }

            System.out.print("Enter your Name: ");
            String adminName = sc.nextLine();
            if (adminName.isEmpty()) {
                System.out.println("Invalid name or Admin Name is empty.");
                return;
            }

            System.out.print("Enter Your Email: ");
            String adminEmail = sc.nextLine();

            System.out.print("Enter your Phone No: ");
            String adminPhone = sc.nextLine();


            admin.setAdminId(adminId);
            admin.setAdminName(adminName);
            admin.setAdminEmail(adminEmail);
            admin.setAdminPhone(adminPhone);
            admins.put(adminId, admin);

            System.out.println("Admin information saved successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred while saving admin information.");
        }
    }

    public void displayAdminInfo() {
        try {
            if (admins.isEmpty()) {
                throw new AdminNotFoundException("No admin records found.");

            }
                System.out.println("Admin Information  is as follow ");
                for (Map.Entry<Integer, Admin> entry : admins.entrySet()) {
                    System.out.println("Admin ID: " + entry.getKey() + ", Admin Info: " + entry.getValue());
                }
            } catch(AdminNotFoundException e){
                System.out.println(e.getMessage());
            } catch(Exception e){
                System.out.println("An error occurred while fetching admin information.");
            }

    }
}
