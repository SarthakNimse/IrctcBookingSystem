package com.irctcbooking.controller;

import com.irctcbooking.model.*;
import com.irctcbooking.service.*;

import java.util.Scanner;

public class BookingFlow {

    private final Scanner sc = new Scanner(System.in);


    private final UserService userService = new UserService();
    private final TrainService trainService = new TrainService();
    private final TicketService ticketService = new TicketService();
    private final PaymentService paymentService = new PaymentService();
    private final BookingHistoryService bookingHistoryService = new BookingHistoryService();
    private final NotificationAlertService notificationAlertService = new NotificationAlertService();

    public void startBookingFlow(){
        System.out.println("\n Starting Booking Flow ");

        //user Info

        User user = new User();
        System.out.println("Enter User Id: ");
        user.setUserId(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter Name ");
        user.setUsername(sc.nextLine());
        System.out.println("Enter Email: ");
        user.setEmail(sc.nextLine());
        System.out.println("User Info Collected");

        //Train Info

        Train train = new Train();
        System.out.println("Enter Train Name: ");
        train.setTrainName(sc.nextLine());
        System.out.println("Enter Train Id: ");
        train.setTrainId(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter Destination: ");
        train.setDestinationStation(sc.nextLine());
        System.out.println(" Train Info Collected");

        //Ticket

        Ticket ticket = new Ticket();
        System.out.println("Enter Ticket Id: ");
        ticket.setTicketId(Integer.parseInt(sc.nextLine()));
        ticket.setUserId(user.getUserId());
        ticket.setTrainId(train.getTrainId());
        System.out.println(" Hurray Ticket Booked");

        //payment

        Payment payment = new Payment();
        System.out.println("Enter Payment Id: ");
        payment.setPaymentId(sc.nextLine());
        System.out.println("Enter Payment Method (UPI/CARD): ");
        payment.setPaymentMethod(sc.nextLine());
        payment.setAmount(500.0);  // fixed for now
        System.out.println("Payment Processed");

        //Booking History

        BookingHistory history = new BookingHistory();
        history.setBookingId(ticket.getTicketId() + 100);
        history.setUserId(user.getUserId());
        history.setTicketId(ticket.getTicketId());
        history.setTrainName(train.getTrainName());
        history.setPaymentId(payment.getPaymentId());


        System.out.println("----------------------------Booking History Recorded.------------------------------- ");
        System.out.println("");

        bookingHistoryService.saveBooking(history);
        notificationAlertService.sendBookingNotification(user.getUsername(),train.getTrainName());

        System.out.println("");
        System.out.println("-------------------Booking Successful Thank You For Using IRCTC.--------------");



    }
}
