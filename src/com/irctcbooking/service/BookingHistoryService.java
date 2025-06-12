package com.irctcbooking.service;

import com.irctcbooking.exception.BookingCancellationException;
import com.irctcbooking.exception.BookingNotFoundException;
import com.irctcbooking.model.BookingHistory;

import java.util.HashMap;
import java.util.Scanner;

public class BookingHistoryService {

    private HashMap<Integer, BookingHistory> bookinghistoryservices = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void acceptBookingHistoryInfo() {
        BookingHistory bookinghistory = new BookingHistory();

        System.out.println("Enter Booking ID: ");
        int bookingId = Integer.parseInt(sc.nextLine());

        bookinghistory.setBookingId(bookingId);
        bookinghistoryservices.put(bookingId, bookinghistory);

        System.out.println("Booking information saved successfully!");
    }

    public void displayBookingHistoryInfo() {
        System.out.println("Enter Booking ID to fetch details: ");
        int bookingId = Integer.parseInt(sc.nextLine());

        if (!bookinghistoryservices.containsKey(bookingId)) {
            throw new BookingNotFoundException("Booking with ID " + bookingId + " not found!");
        }

        BookingHistory booking = bookinghistoryservices.get(bookingId);
        System.out.println("Booking Details: " + booking);
    }

    public void cancelBooking() {
        System.out.println("Enter Booking ID to cancel: ");
        int bookingId = Integer.parseInt(sc.nextLine());

        if (!bookinghistoryservices.containsKey(bookingId)) {
            throw new BookingNotFoundException("Booking ID " + bookingId + " not found, cancellation failed!");
        }

        boolean isCancelable = checkCancellationPolicy(bookingId);
        if (!isCancelable) {
            throw new BookingCancellationException("Booking ID " + bookingId + " cannot be canceled as per policy.");
        }

        bookinghistoryservices.remove(bookingId);
        System.out.println("Booking ID " + bookingId + " has been canceled successfully!");
    }

    private boolean checkCancellationPolicy(int bookingId) {
        return bookingId % 2 == 0;
    }
}

