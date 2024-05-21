package com.pluralsite;

import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    Dealership dealership = new Dealership();
    Vehicle vehicle = new Vehicle();

    private void init(Dealership dealership) {
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.getDealership(dealership);
    }

    public void displayHome() {
        init(dealership);
        System.out.println("Welcome to " + dealership.getDealerName() + "!\nWhat would you like to do?");
        options();

    }

    public void options() {
        System.out.println("""
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
                10) Save to file
                0) Exit program""");
        select();
    }

    public void select() {
        try {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    getByPriceRequest();
                    redirect();
                    break;
                case 2:
                    scanner.nextLine();
                    getByMakeModelRequest();
                    redirect();
                    break;
                case 3:
                    getByYearRequest();
                    redirect();
                    break;
                case 4:
                    scanner.nextLine();
                    getByColorRequest();
                    redirect();
                    break;
                case 5:
                    getByMileageRequest();
                    redirect();
                    break;
                case 6:
                    scanner.nextLine();
                    getByVehicleTypeRequest();
                    redirect();
                    break;
                case 7:
                    getAllVehiclesRequest();
                    redirect();
                    break;
                case 8:
                    addVehicleRequest();
                    save();
                    break;
                case 9:
                    removeVehicleRequest();
                    save();
                    break;
                case 10:
                    save();
                    break;
                case 0:
                    closeProgram();
                default:
                    System.out.println("Invalid input");
                    options();
                    break;
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input");
            options();
        }
    }

    public void redirect() {
        try {
            System.out.println("\n1) Continue\n0) exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                options();
            } else if (choice == 0) {
                closeProgram();
            } else {
                System.out.println("Invalid input");
                redirect();
            }
        } catch (Exception exception) {
            System.out.println("Invalid input");
            redirect();
        }
    }

    public void save() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        try {
            System.out.println("Save?");
            System.out.println("\n1) Save and continue\n2) Continue without saving");
            int choice = scanner.nextInt();
            if (choice == 1) {
                dealershipFileManager.saveDealership(dealership);
                options();
            } else if (choice == 2) {
                options();
            } else {
                System.out.println("Invalid input");
                save();
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            save();
        }
    }


    public void getByPriceRequest() {
        System.out.println("Enter minimum price: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum price");
        int max = scanner.nextInt();
        for (Vehicle vehicle : dealership.getInventory()) {
            if (min <= vehicle.getPrice() && max >= vehicle.getPrice()) {
                System.out.println(vehicle);
            }
        }
    }

    public void getByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        for (Vehicle vehicle : dealership.getInventory()) {
            String term1 = vehicle.getMake();
            String term2 = vehicle.getModel();
            if (term1.equalsIgnoreCase(make) && term2.equalsIgnoreCase(model)) {
                System.out.println(vehicle);
            }
        }
    }

    public void getByYearRequest() {
        System.out.println("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum year");
        int max = scanner.nextInt();
        for (Vehicle vehicle : dealership.getInventory()) {
            if (min <= vehicle.getYear() && max >= vehicle.getYear()) {
                System.out.println(vehicle);
            }
        }
    }

    public void getByColorRequest() {
        System.out.println("Enter color: ");
        String search = scanner.nextLine();
        for (Vehicle vehicle : dealership.getInventory()) {
            String output = vehicle.getColor();
            if (output.equalsIgnoreCase(search)) {
                System.out.println(vehicle);
            }
        }
    }

    public void getByMileageRequest() {
        System.out.println("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.println("Enter max mileage");
        int max = scanner.nextInt();
        for (Vehicle vehicle : dealership.getInventory()) {
            if (min <= vehicle.getOdometer() && max >= vehicle.getOdometer()) {
                System.out.println(vehicle);
            }
        }
    }

    public void getByVehicleTypeRequest() {
        System.out.println("Enter vehicle type: ");
        scanner.nextLine();
        String search = scanner.nextLine();
        for (Vehicle vehicle : dealership.getInventory()) {
            String output = vehicle.getVehicleType();
            if (output.equalsIgnoreCase(search)) {
                System.out.println(vehicle);
            }
        }
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
        try {
            System.out.println("Enter values:");
            System.out.print("Vin: ");
            vehicle.setVin(scanner.nextInt());
            System.out.print("Year: ");
            vehicle.setYear(scanner.nextInt());
            System.out.print("Make: ");
            scanner.nextLine();
            vehicle.setMake(scanner.nextLine());
            System.out.print("Model: ");
            vehicle.setModel(scanner.nextLine());
            System.out.print("Vehicle type: ");
            vehicle.setVehicleType(scanner.nextLine());
            System.out.print("Color: ");
            vehicle.setColor(scanner.nextLine());
            System.out.print("Mileage: ");
            vehicle.setOdometer(scanner.nextInt());
            System.out.print("Price: ");
            vehicle.setPrice(scanner.nextDouble());
            dealership.addVehicle(vehicle);
        } catch (Exception e) {
            System.out.println("Invalid input");
            addVehicleRequest();
        }
    }

    public void removeVehicleRequest() {
        try {
            getAllVehiclesRequest();
            System.out.println("\nEnter vin of the vehicle you would like to remove:");
            int choice = scanner.nextInt();
            for (Vehicle vehicle : dealership.getInventory()) {
                if (choice == vehicle.getVin()) {
                    dealership.removeVehicle(vehicle);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            removeVehicleRequest();
        }
    }

    public void closeProgram() {
        System.out.println("Goodbye");
        System.exit(0);
    }
}
