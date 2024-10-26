package com.travelbookingsystem;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private ArrayList<Trip> bookedTrips;

    public User(String username, String password, String fullName, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookedTrips = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addTrip(Trip trip) {
        bookedTrips.add(trip);
    }

    public ArrayList<Trip> getBookedTrips() {
        return bookedTrips;
    }

    public void cancelTrip(Trip trip) {
        bookedTrips.remove(trip);
        System.out.println("Trip from " + trip.getSource() + " to " + trip.getDestination() + " has been cancelled.");
    }
}


