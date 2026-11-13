package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public UserInterface() {

    }

    public void display() {
        init();

        System.out.println(" - Welcome to the " + dealership.getName() + " Inventory Management System -");
        while (true) {
            System.out.println("""
                    \t[1] Find Vehicles by Price
                    \t[2] Find Vehicles by Make/Model
                    \t[3] Find Vehicles by Year
                    \t[4] Find Vehicles by Color
                    \t[5] Find Vehicles by Mileage
                    \t[6] Find Vehicles by Type
                    \t[7] Find All Vehicles
                    \t[8] Add Vehicle
                    \t[9] Remove Vehicle
                    \t[0] Exit""");
            System.out.println();
            System.out.print("Enter your selection: ");
            System.out.println();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "0" -> {
                    System.out.println("Goodbye! Thank you for using the inventory management system!");
                    System.exit(0);
                }
            }
        }

    }

    private void displayVehicles(ArrayList<Vehicle> inventory) {
        if (!inventory.isEmpty()) {
            System.out.println();
            System.out.println( "-------------------------------------------------------------------------------------------------------" );
            System.out.printf("|%s|%s|%s|%s|%s|%s|%s| $%s|%n", center("VIN", 10),
                    center("YEAR", 10),
                    center("MAKE", 12),
                    center("MODEL", 12),
                    center("TYPE", 12),
                    center("COLOR", 12),
                    center("MILEAGE", 12),
                    center("PRICE", 12));
            System.out.println();

            for (Vehicle vehicle : inventory) {
                System.out.printf("|%s|%s|%s|%s|%s|%s|%s| $%s|%n",
                        center(Integer.toString(vehicle.getVin()), 10),
                        center(Integer.toString(vehicle.getYear()), 10),
                        center(vehicle.getMake(), 12),
                        center(vehicle.getModel(), 12),
                        center(vehicle.getVehicleType(), 12),
                        center(vehicle.getColor(), 12),
                        center(Integer.toString(vehicle.getOdometer()), 12),
                        center(vehicle.getPrice().toString(), 12));
            }
        } else {
            System.out.println("No vehicles found matching this request.");
        }

        pressEnterToContinue();

    }

    private static String center(String text, int width) {
        int leftover = width - text.length();
        if (leftover <= 0) {
            return text;
        }
        int left = leftover / 2;
        int right = leftover - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

    public void processGetByPriceRequest() {
        displayVehicles(dealership.getVehiclesByPrice(promptForString(), promptForString()));
    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    public String promptForString() {
        String string;

        while (true) {
            string = scanner.nextLine().trim().toLowerCase();

            if (string.isEmpty()) {
                System.out.println("Input not recorded, please try again!");
                continue;
            }
            if (string.contains("|")) {
                System.out.println("Please do not use '|', try again.");
                continue;
            }
            return string;
        }
    }

    private void pressEnterToContinue() {
        System.out.println();
        System.out.println("Press enter to return to the menu...");
        scanner.nextLine();
    }
}
