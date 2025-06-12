package com.irctcbooking.model;

public class BookingHistory {

    private int bookingId;
    private int userId;
    private String trainName;
    private int ticketId;
    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    @Override
    public String toString() {
        return "BookingHistory{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", trainName='" + trainName + '\'' +
                ", ticketId=" + ticketId +
                ", payment='" + paymentId + '\'' +
                '}';
    }
}

