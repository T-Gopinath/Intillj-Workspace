package designPatterns.creational.abstractFactoryMethod;

class ElectricVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new ElectricCar();
    }

    public Bike createBike() {
        return new ElectricBike();
    }
}

class PetrolVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new PetrolCar();
    }

    public Bike createBike() {
        return new PetrolBike();
    }
}
