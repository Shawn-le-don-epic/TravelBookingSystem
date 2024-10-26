package com.travelbookingsystem;

import java.util.List;
import java.util.Scanner;

public class Admin {
    private String adminUsername;
    private String adminPassword;
    private List<Location> locations;

    public Admin(List<Location> locations) {
        this.adminUsername = "admin";
        this.adminPassword = "admin123";
        this.locations = locations;
    }

    public boolean login(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    public void addLocation(Scanner scanner) {
        System.out.print("Enter Source: ");
        String source = scanner.next();
        Location location = new Location(source);
        locations.add(location);

        System.out.print("Enter number of destinations for " + source + ": ");
        int numDestinations = scanner.nextInt();
        for (int i = 0; i < numDestinations; i++) {
            System.out.print("Enter Destination " + (i + 1) + ": ");
            String destination = scanner.next();
            location.addDestination(destination);
        }

        System.out.print("Enter number of transport options for " + source + ": ");
        int numTransportOptions = scanner.nextInt();
        for (int i = 0; i < numTransportOptions; i++) {
            System.out.print("Enter Transport Option " + (i + 1) + ": ");
            String transportOption = scanner.next();
            location.addTransportOption(transportOption);
        }
        System.out.println("Location added successfully!");
    }

    public List<Location> getLocations() {
        return locations;
    }
}


