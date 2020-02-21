package com.example.day4;

public class Bus extends CommonCar {

    private int capacity;

    public Bus(String carName, int capacity){
        this.carName= carName;
        this.capacity = capacity;
    }
    @Override
    public  void  displayInfo(){
        System.out.printf("%s, %s (승객수 : %s)\n", brandName, carName, capacity);
    }
}
