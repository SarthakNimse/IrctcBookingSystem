package com.irctcbooking.service;

import com.irctcbooking.exception.InvalidUserDetailsException;
import com.irctcbooking.exception.UserNotFoundException;
import com.irctcbooking.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UserService {

    private HashMap<Integer, User> users = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void acceptUserInfo() {
        User user = new User();

        System.out.println("Enter your user id: ");
        int userId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter Your Full Name: ");
        String fullName = sc.nextLine();
        if (fullName.isEmpty()) {
            throw new InvalidUserDetailsException("Full Name cannot be empty!");
        }

        System.out.println("Enter Your User Name: ");
        String username = sc.nextLine();
        if (username.isEmpty()) {
            throw new InvalidUserDetailsException("Username cannot be empty!");
        }

        System.out.println("Enter Your Email: ");
        String email = sc.nextLine();


        System.out.println("Enter Your Phone no: ");
        String phoneNo = sc.nextLine();


        user.setUserId(userId);
        user.setFullName(fullName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhoneNo(phoneNo);
        users.put(userId, user);

        System.out.println("User information saved successfully!");
    }

    public void displayUserInfo() {
        System.out.println("Enter User ID to fetch details: ");
        int userId = Integer.parseInt(sc.nextLine());

        if (!users.containsKey(userId)) {
            throw new UserNotFoundException("User with ID " + userId + " not found!");
        }

        for (Map.Entry<Integer, User> set : users.entrySet()) {
            System.out.println("User ID: " + set.getKey() + ", User Info: " + set.getValue());

            System.out.println("User information you requested");
        }


    }
}
