package unit11.b;

class Vehicle {
    private int numWheels;

    public Vehicle(int numWheels) {
        this.numWheels = numWheels;
    }

    public String toString() {
        return this.getClass().getName() + " with " + numWheels + " wheels...huh?";
    }
}

// Code me! bikes have 2 wheels
public class Bike extends Vehicle{
    public Bike(){
        super(3);
    }

    public static void main(String[] args) {
        Bike bike = new Bike();
        System.out.println(bike);
    }
}
