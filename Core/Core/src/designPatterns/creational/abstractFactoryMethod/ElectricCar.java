package designPatterns.creational.abstractFactoryMethod;

// Electric Vehicles
class ElectricCar implements Car {
    public void drive() {
        System.out.println("Driving Electric Car");
    }
}

class ElectricBike implements Bike {
    public void ride() {
        System.out.println("Riding Electric Bike");
    }
}

// Petrol Vehicles
class PetrolCar implements Car {
    public void drive() {
        System.out.println("Driving Petrol Car");
    }
}

class PetrolBike implements Bike {
    public void ride() {
        System.out.println("Riding Petrol Bike");
    }
}
