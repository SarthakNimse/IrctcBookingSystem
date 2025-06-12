package com.irctcbooking.service;

import com.irctcbooking.exception.TrainNotFoundException;
import com.irctcbooking.model.Train;

import java.util.HashMap;
import java.util.Scanner;

public class TrainService {

    private HashMap<Integer, Train> trains = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void acceptTrainInfo() {
        Train train = new Train();

        System.out.println("Enter your train Id: ");
        int trainId = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your train Name: ");
        String trainName = sc.nextLine();

        System.out.println("Enter your sourceStation: ");
        String sourceStation = sc.nextLine();

        System.out.println("Enter your destinationStation: ");
        String destinationStation = sc.nextLine();

        System.out.println("Enter your departureTime: ");
        String departureTime = sc.nextLine();

        System.out.println("Enter your arrivalTime: ");
        String arrivalTime = sc.nextLine();

        System.out.println("Enter your total seats: ");
        int totalSeats = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your available seats: ");
        int availableSeats = Integer.parseInt(sc.nextLine());

        System.out.println("Enter your price per seat: ");
        double pricePerSeat = sc.nextDouble();
        sc.nextLine(); // Consume newline

        train.setTrainId(trainId);
        train.setTrainName(trainName);
        train.setSourceStation(sourceStation);
        train.setDestinationStation(destinationStation);
        train.setDepartureTime(departureTime);
        train.setArrivalTime(arrivalTime);
        train.setTotalSeats(totalSeats);
        train.setAvailableSeats(availableSeats);
        train.setPricePerSeat(pricePerSeat);
        trains.put(trainId, train);

        System.out.println("Train information saved successfully!");
    }

    public void displayTrainInfo() {
        System.out.println("Enter Train ID to fetch details: ");
        int trainId = Integer.parseInt(sc.nextLine());

        if (!trains.containsKey(trainId)) {
            throw new TrainNotFoundException("Train with ID " + trainId + " not found!");
        }

        Train train = trains.get(trainId);
        System.out.println("Train Details: " + train);
    }
}

