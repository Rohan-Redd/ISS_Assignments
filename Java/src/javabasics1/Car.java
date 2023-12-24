package javabasics1;

public class Car {
    public String make;
    public String model;
    public int currentSpeed;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.currentSpeed = 0;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void accelerate(int speedIncrease) {
        if (speedIncrease > 0) {
            currentSpeed += speedIncrease;
            System.out.println(make + " " + model + " is accelerating. Current speed: " + currentSpeed + " km/h");
        } else {
            System.out.println("Invalid speed increase. Speed must be greater than 0.");
        }
    }

    public void brake(int speedDecrease) {
        if (speedDecrease > 0 && currentSpeed - speedDecrease >= 0) {
            currentSpeed -= speedDecrease;
            System.out.println(make + " " + model + " is braking. Current speed: " + currentSpeed + " km/h");
        } else {
            System.out.println("Invalid speed decrease. Speed must be greater than 0 and not exceed the current speed.");
        }
    }
}
