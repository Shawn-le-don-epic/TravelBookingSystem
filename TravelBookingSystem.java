package com.travelbookingsystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Location> locations = new ArrayList<>();
        Admin admin = new Admin(locations); // Pass locations to admin
        BookingService bookingService = new BookingService(locations); // Pass locations to booking service

        // Admin Login and Add Locations
        System.out.println("Admin Login:");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        if (admin.login(username, password)) {
            System.out.println("Login successful!");
            while (true) {
                System.out.println("1. Add Location");
                System.out.println("2. Logout");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    admin.addLocation(scanner);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid credentials.");
        }

        // User Management and Booking Trips
        UserService userService = new UserService();
        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                userService.signUp(scanner);
            } else if (choice == 2) {
                userService.login(scanner, bookingService); // Pass booking service
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close(); // Close the scanner
    }
}

