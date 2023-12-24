// Implementing basic concepts of Java: Class, Object, State and Methods.

package javabasics1;

public class Main {
    public static void main(String[] args) {
        // Creating a Car object
        Car myCar = new Car("Mclaren", "Senna");

        // Displaying the initial state of the car
        System.out.println("Initial state of the car:");
        System.out.println("Make: " + myCar.make);
        System.out.println("Model: " + myCar.model);
        System.out.println("Current speed: " + myCar.getCurrentSpeed() + " km/h");

        // Accelerating the car
        myCar.accelerate(30);

        // Braking the car
        myCar.brake(10);
    }
}