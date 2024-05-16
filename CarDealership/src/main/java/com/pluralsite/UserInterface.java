package com.pluralsite;

import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    Dealership dealership = new Dealership();
    private void init(Dealership dealership) {
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.getDealership(dealership);
    }

    public void displayHome() {
        init(dealership);
        System.out.println("Welcome to " + dealership.getDealerName() + "!");
        displayOptions();

    }

    public void displayOptions() {
        System.out.println("""
                What would you like to do?
                ----Options----
                1) Search by price
                2) Search by make and model
                3) Search by year
                4) Search by color
                5) Search by mileage
                6) Search by vehicle type
                7) List all vehicles
                8) Add vehicle
                9) Remove vehicle
                0) Exit""");
        select();
    }

    public void select() {
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                getByPriceRequest();
                break;
            case 2:
                getByMakeModelRequest();
                break;
            case 3:
                getByYearRequest();
                break;
            case 4:
                getByColorRequest();
                break;
            case 5:
                getByMileageRequest();
                break;
            case 6:
                getByVehicleTypeRequest();
                break;
            case 7:
                getAllVehiclesRequest();
                break;
            case 8:
                addVehicleRequest();
                break;
            case 9:
                removeVehicleRequest();
                break;
            case 0:
                System.exit(0);
                break;
        }

    }



    public void getByPriceRequest() {

    }

    public void getByMakeModelRequest() {

    }

    public void getByYearRequest() {

    }

    public void getByColorRequest() {

    }

    public void getByMileageRequest() {

    }

    public void getByVehicleTypeRequest() {

    }

    public void getAllVehiclesRequest() {
        Iterator<Vehicle> vehicleIterator = dealership.getInventory().iterator();
        String output;
        while (vehicleIterator.hasNext()) {
            output = String.valueOf(vehicleIterator.next());
            System.out.println(output);
        }
    }

    public void addVehicleRequest() {

    }

    public void removeVehicleRequest() {

    }
}
