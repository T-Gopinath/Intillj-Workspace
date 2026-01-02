package designPatterns.creational.abstractFactoryMethod;

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        VehicleFactory factory = new ElectricVehicleFactory();
        Car car = factory.createCar();
        Bike bike = factory.createBike();

        car.drive();
        bike.ride();
    }
}

/**
 * 🚗 Real-World Example: Vehicle Factory
 *
 * We want to create families of vehicles:
 *
 * Electric Vehicles
 *
 * Petrol Vehicles
 *
 * Each family produces:
 *
 * Car
 *
 * Bike
 */
