package com.travelbookingsystem;

import java.util.Scanner;

public class Payment {
    public void processPayment(Scanner scanner) {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Net Banking");
        System.out.println("4. UPI");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        String method;
        switch (choice) {
            case 1:
                method = "Credit Card";
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = scanner.next();
                System.out.print("Enter Expiry Date (MM/YY): ");
                String expiryDate = scanner.next();
                System.out.print("Enter CVV: ");
                String cvv = scanner.next();

                // Simulate credit card payment process
                System.out.println("Processing Credit Card payment...");

                break;
            case 2:
                method = "Debit Card";
                System.out.print("Enter Debit Card Number: ");
                String cardNo = scanner.next();
                System.out.print("Enter Expiry Date (MM/YY): ");
                String expryDt = scanner.next();
                System.out.print("Enter CVV: ");
                String cvvNo = scanner.next();

                // Simulate debit card payment process
                System.out.println("Processing Debit Card payment...");

                break;
            case 3:
                method = "Net Banking";
                System.out.print("Enter Bank Name: ");
                String bankName = scanner.next();
                System.out.print("Enter User ID: ");
                String userID = scanner.next();
                System.out.print("Enter Password: ");
                String password = scanner.next();

                // Simulate net banking payment process
                System.out.println("Processing Net Banking payment...");

                break;
            case 4:
                method = "UPI";
                for(int i=0;i<5;i++) {
                    for(int j=0;j<5;j++) {
                        if(Math.random() > 0.7) {
                            System.out.print("*");
                        }
                        else {
                            System.out.print("#");
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Invalid choice. Please select a valid payment method.");
                return;
        }
        System.out.println("Payment method selected: " + method);
        System.out.println("Processing payment...");
        System.out.println("Payment successful!");
    }
}


