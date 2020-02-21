package com.example.day4;

public class CarFactory {
    public static void main(String[] args) {
        Car car1 = new Car("쏘나타", 4);
        car1.displayInfo();

        Car car2 = new Car("쏘나타2",2);
        car2.displayInfo();

        SportsCar car3 = new SportsCar("Sp one",2);
        car3.displayInfo();

        Bus car4 = new Bus("마을버스", 15);
        car4.displayInfo();
    }
}
