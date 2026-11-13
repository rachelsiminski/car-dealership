package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    //public void setInventory(ArrayList<Vehicle> inventory) {
    //    this.inventory = inventory;
    //}

    public ArrayList<Vehicle> getVehiclesByPrice(String min, String max) {
        ArrayList<Vehicle> byPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice().compareTo(new BigDecimal(min)) >= 0 && vehicle.getPrice().compareTo(new BigDecimal(max)) <= 0) {
                byPrice.add(vehicle);
            }
        }
        return byPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> byMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                byMakeModel.add(vehicle);
            }
        }
        return byMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int year) {
        ArrayList<Vehicle> byYear = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() == year) {
                byYear.add(vehicle);
            }
        }
        return byYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> byColor = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                byColor.add(vehicle);
            }
        }
        return byColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> byMileage = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                byMileage.add(vehicle);
            }
        }
        return byMileage;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

}
