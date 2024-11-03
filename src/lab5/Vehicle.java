package lab5;
/*
 * @Phemelo Moloi
 * @ID: 22001164
 * dear Sir, I am mortified to present to you another piece of code that isn't optimized or refactors
 * I admit implementing polymorphism was harder than anticipated but i Still did attempt to
 * The code is bad, but it gets the work done, I hope
 * again i apologize for making you see such bad work but trust me, it'll get better.
 */

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private String brand;
    private double speed;
    private int capacity;

    // Default constructor
    public Vehicle() {
        this.brand = " ";
        this.speed = 0.0;
        this.capacity = 0;
    }

    // Parameterized constructor
    public Vehicle(String brand, double speed, int capacity) {
        this.brand = brand;
        this.speed = speed;
        this.capacity = capacity;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Method to start engine
    public void startEngine() {
        System.out.println("Engine started");
    }

    // Method to stop engine
    public void stopEngine() {
        System.out.println("Engine stopped");
    }

    // Method to move
    public void move() {
        System.out.println("Vehicle is moving");
    }

    // Overridden toString method for general vehicle information
    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", capacity=" + capacity +
                '}';
    }

    public double calculateFuelEfficiency(double distance, double fuelConsumed) {
        if (fuelConsumed == 0) {
            throw new IllegalArgumentException("Fuel consumed cannot be zero.");
        }
        return distance / fuelConsumed; // Example calculation
    }
}

class Car extends Vehicle {

    private int numberOfDoors;

    // Constructor for Car
    public Car(String brand, double speed, int capacity, int numberOfDoors) {
        super(brand, speed, capacity);
        this.numberOfDoors = numberOfDoors;
    }

    // Getters and Setters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed) {
        return distance / fuelConsumed;
    }

    // Overridden toString method for specific car information
    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}

class Truck extends Vehicle {

    private int loadCapacity;

    // Constructor for Truck
    public Truck(String brand, double speed, int capacity, int loadCapacity) {
        super(brand, speed, capacity);
        this.loadCapacity = loadCapacity;
    }

    // Getters and Setters
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed) {
        // Consider load and terrain
        double efficiencyFactor = 1.0; // Adjust based on load and terrain
        return (distance / fuelConsumed) * efficiencyFactor;
    }

    // Overridden toString method for specific truck information
    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}

class Motorbike extends Vehicle {

    private String engineType;

    // Constructor for Motorbike
    public Motorbike(String brand, double speed, int capacity, String engineType) {
        super(brand, speed, capacity);
        this.engineType = engineType;
    }

    // Getters and Setters
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public double calculateFuelEfficiency(double distance, double fuelConsumed) {
        return distance / fuelConsumed;
    }

    // Overridden toString method for specific motorbike information
    @Override
    public String toString() {
        return "Motorbike{" +
                super.toString() +
                ", engineType='" + engineType + '\'' +
                '}';
    }
}

class Garage {
    private List<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void listVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void searchVehicle(String brand) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equals(brand)) {
                System.out.println(vehicle.toString());
            }
        }
    }
}

class main {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry", 120.0, 5, 4);
        Truck truck = new Truck("Ford F-150", 80.0, 2, 1000);
        Motorbike motorbike = new Motorbike("Honda CBR", 150.0, 2, "4-stroke");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(motorbike);

        for (Vehicle vehicle : vehicles) {
            double distance = 100;
            double fuelConsumed = 10;
            double efficiency = vehicle.calculateFuelEfficiency(distance, fuelConsumed);
            System.out.println(vehicle.getClass().getSimpleName() + " fuel efficiency: " + efficiency + " km/liter");
        }
    }
}
