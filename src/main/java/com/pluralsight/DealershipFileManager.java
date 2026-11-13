package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    private Dealership dealership;

    public Dealership getDealership() {
        System.out.println("Accessing file...");
        System.out.println();
        System.out.println();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dealership-inventory.csv"))) {
            bufferedReader.readLine();

            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isBlank()) {
                    String[] fields = line.split("\\|");
                    if (count == 0) {
                        dealership = new Dealership(fields[0], fields[1], fields[2]);
                        count++;
                    } else if (fields.length != 8) {
                        System.out.println("Skipping malformed line #" + count + ": " + line);
                        count++;
                    }
                    try {
                        Vehicle vehicle = new Vehicle(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2], fields[3], fields[4], fields[5], Integer.parseInt(fields[6]), new BigDecimal(fields[7]));
                        dealership.addVehicle(vehicle);
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid vehicle line #" + count + ": " + line);
                        count++;
                    }
                }
            }
            System.out.println(dealership.getInventory().size());
            System.out.println("File read successful!");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dealership-inventory.csv", true));

            for (Vehicle vehicle : dealership.getInventory()) {
                bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
        }
    }
}
