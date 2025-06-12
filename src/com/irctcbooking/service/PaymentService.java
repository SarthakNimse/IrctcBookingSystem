package com.irctcbooking.service;

import com.irctcbooking.exception.InvalidPaymentMethodException;
import com.irctcbooking.exception.PaymentFailedException;
import com.irctcbooking.model.Payment;

import java.util.HashMap;
import java.util.Scanner;

public class PaymentService {

    private HashMap<Integer, Payment> payments = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    private static final String[] VALID_PAYMENT_METHODS = {"Credit Card", "Debit Card", "UPI", "Net Banking"};

    public void acceptPaymentInfo() {
        Payment payment = new Payment();

        System.out.println("Enter your payment Id: ");
        int paymentId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your payment Date: ");
        String paymentDate = sc.nextLine();

        System.out.println("Enter Payment Method (Credit Card/Debit Card/UPI/Net Banking): ");
        String paymentMethod = sc.nextLine();

        if (!isValidPaymentMethod(paymentMethod)) {
            throw new InvalidPaymentMethodException("Invalid Payment Method: " + paymentMethod + ". Please use Credit Card, Debit Card, UPI, or Net Banking.");
        }

        System.out.println("Enter Amount: ");
        double amount = sc.nextDouble();


        System.out.println("Enter Payment Status (Success/Failed): ");
        String paymentStatus = sc.nextLine();

        if (paymentStatus.equalsIgnoreCase("Failed")) {
            throw new PaymentFailedException("ayment failed for Payment ID: " + paymentId);
        }

        payment.setPaymentId(paymentId);
        payment.setPaymentDate(paymentDate);
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setPaymentStatus(paymentStatus);
        payments.put(paymentId, payment);

        System.out.println("Payment information saved successfully!");
    }

    public void displayPaymentInfo() {
        System.out.println("Enter Payment ID to fetch details: ");
        int paymentId = Integer.parseInt(sc.nextLine());

        if (!payments.containsKey(paymentId)) {
            throw new PaymentFailedException("Payment with ID " + paymentId + " not found!");
        }

        Payment payment = payments.get(paymentId);
        System.out.println("Payment Details: " + payment);
    }

    private boolean isValidPaymentMethod(String method) {
        for (String validMethod : VALID_PAYMENT_METHODS) {
            if (validMethod.equalsIgnoreCase(method)) {
                return true;
            }
        }
        return false;
    }
}

