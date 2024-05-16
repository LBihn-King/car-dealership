package com.pluralsite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    private ArrayList<Vehicle> vehicles = new ArrayList<>(); //create array list to hold vehicles
    public void getDealership(Dealership dealership) {
        parseDealership(dealership);
        parseVehicle();
        dealership.setInventory(vehicles);
    }

    private void parseDealership(Dealership dealership) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("inventory.csv"));
            String input = bfr.readLine(); //read the first line of the file
            String[] tokens = input.split("\\|");
            dealership.setDealerName(tokens[0]);// set dealer values
            dealership.setAddress(tokens[1]);
            dealership.setPhone(tokens[2]);
            bfr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseVehicle() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("inventory.csv")); // create buffered reader with input file
            String input; // create string to hold input
            bfr.readLine(); //skip first line
            while ((input = bfr.readLine()) != null) {
                String[] tokens = input.split("\\|"); // split the input
                // parse the tokens
                int vin = Integer.parseInt(tokens[0]); //set vehicle values
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price); //create new vehicle object
                vehicles.add(vehicle); //add vehicle to array list
            }
            bfr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(){

    }
}
