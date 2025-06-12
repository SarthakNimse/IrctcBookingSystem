package com.irctcbooking.service;

import com.irctcbooking.exception.SeatsNotAvailableException;
import com.irctcbooking.exception.TicketNotFoundException;
import com.irctcbooking.model.Ticket;

import java.util.HashMap;
import java.util.Scanner;

public class TicketService {

    private HashMap<Integer, Ticket> tickets = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private int availableSeats = 5;

    public void acceptTicketInfo() {
        if (availableSeats == 0) {
            throw new SeatsNotAvailableException("No seats available! Booking cannot proceed.");
        }

        Ticket ticket = new Ticket();

        System.out.println("Enter your ticket ID: ");
        int ticketId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your PNR number: ");
        String pnrNumber = sc.nextLine();

        System.out.println("Enter your seat number: ");
        int seatNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your booking date: ");
        String bookingDate = sc.nextLine();

        System.out.println("Enter your ticket price: ");
        double ticketPrice = sc.nextDouble();


        ticket.setTicketId(ticketId);
        ticket.setPnrNumber(pnrNumber);
        ticket.setSeatNumber(seatNumber);
        ticket.setBookingDate(bookingDate);
        ticket.setTicketPrice(ticketPrice);
        tickets.put(ticketId, ticket);


        System.out.println("Ticket information saved successfully!");
    }

    public void displayTicketInfo() {
        System.out.println("Enter Ticket ID to fetch details: ");
        int ticketId = Integer.parseInt(sc.nextLine());

        if (!tickets.containsKey(ticketId)) {
            throw new TicketNotFoundException("Ticket with ID " + ticketId + " not found!");
        }

        Ticket ticket = tickets.get(ticketId);
        System.out.println("Ticket Details: " + ticket);
    }
}

