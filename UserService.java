package com.travelbookingsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private ArrayList<User> users = new ArrayList<>();

    public void signUp(Scanner scanner) {
        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        System.out.println("Enter Full Name: ");
        String fullName = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.next();
        User user = new User(username, password, fullName, email, phoneNumber);
        users.add(user);
        System.out.println("User registered successfully!");
    }

    public void login(Scanner scanner, BookingService bookingService) {
        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                manageBooking(scanner, user, bookingService);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private void manageBooking(Scanner scanner, User user, BookingService bookingService) {
        while (true) {
            System.out.println("1. Book a Trip");
            System.out.println("2. View Booked Tickets");
            System.out.println("3. Cancel a Trip");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookingService.bookTrip(scanner, user);
                    break;
                case 2:
                    bookingService.viewBookedTickets(user);
                    break;
                case 3:
                    bookingService.cancelTrip(scanner, user);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

