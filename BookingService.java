package com.travelbookingsystem;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BookingService {
    private List<Location> locations;
    private List<String> accommodationOptions = List.of(
            "1. Hotel", "2. Hostel", "3. Apartment", "4. Guest House", "5. Resort", "6. Motel", "7. Villa", "8. None"
    );

    public BookingService(List<Location> locations) {
        this.locations = locations;
    }

    public void bookTrip(Scanner scanner, User user) {
        System.out.println("Booking a new trip...");
        System.out.println("Select Source:");
        for (int i = 0; i < locations.size(); i++) {
            System.out.println((i + 1) + ". " + locations.get(i).getSource());
        }
        int sourceChoice = scanner.nextInt() - 1;
        String selectedSource = locations.get(sourceChoice).getSource();

        System.out.println("Select Destination:");
        List<String> destinations = locations.get(sourceChoice).getDestinations();
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i));
        }
        int destinationChoice = scanner.nextInt() - 1;
        String selectedDestination = destinations.get(destinationChoice);

        System.out.println("Available Transport Options:");
        List<String> transportOptions = locations.get(sourceChoice).getTransportOptions();
        for (int i = 0; i < transportOptions.size(); i++) {
            System.out.println((i + 1) + ". " + transportOptions.get(i));
        }
        int transportChoice = scanner.nextInt() - 1;
        String selectedTransport = transportOptions.get(transportChoice);

        System.out.println("Select Accommodation:");
        for (String option : accommodationOptions) {
            System.out.println(option);
        }
        int accommodationChoice = scanner.nextInt();
        String accommodation = accommodationOptions.get(accommodationChoice - 1).substring(3);

        Trip trip = new Trip("2024-12-15", selectedSource, selectedDestination, selectedTransport, accommodation);
        user.addTrip(trip);

        Payment payment = new Payment();
        payment.processPayment(scanner);
        System.out.println("Trip booked successfully!");
    }

    public void viewBookedTickets(User user) {
        ArrayList<Trip> trips = user.getBookedTrips();
        if (trips.isEmpty()) {
            System.out.println("No trips booked yet.");
            return;
        }
        System.out.println("Here are your booked trips:");
        for (Trip trip : trips) {
            System.out.println("Trip from " + trip.getSource() + " to " + trip.getDestination() + " on " + trip.getStartDate());
            System.out.println("Transport Mode: " + trip.getTransportMode());
            System.out.println("Accommodation: " + trip.getAccommodation());
        }
    }

    public void cancelTrip(Scanner scanner, User user) {
        ArrayList<Trip> trips = user.getBookedTrips();
        if (trips.isEmpty()) {
            System.out.println("No booked trips to cancel.");
            return;
        }
        System.out.println("Your booked trips:");
        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            System.out.println((i + 1) + ". " + trip.getSource() + " to " + trip.getDestination() + " on " + trip.getStartDate());
        }
        System.out.print("Select trip to cancel (enter the number): ");
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < trips.size()) {
            Trip tripToCancel = trips.get(choice);
            user.cancelTrip(tripToCancel);
        } else {
            System.out.println("Invalid selection.");
        }
    }
}


