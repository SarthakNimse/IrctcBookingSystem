package com.irctcbooking.model;

public class Ticket {


    private int ticketId;
    private String pnrNumber;
    private int userId;
    private String trainName;
    private int seatNumber;
    private String departureTime;
    private String bookingDate;
    private double ticketPrice;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", pnrNumber='" + pnrNumber + '\'' +
                ", userId=" + userId +
                ", trainName='" + trainName + '\'' +
                ", seatNumber=" + seatNumber +
                ", departureTime='" + departureTime + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

