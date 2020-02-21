package com.example.day4;

public class SportsCar extends CommonCar {
    private int doorCount;
    private int maxSpeed;

    public SportsCar(String carName, int doorCount){
        System.out.println("Child Class");
        this.carName= carName;
        this.doorCount = doorCount;
        this.maxSpeed = 300;
    }
    @Override
    public  void  displayInfo(){
        System.out.printf("%s, %s(도어수는 : %s)(최고 속도는 : %s km/h) \n", brandName, carName, doorCount,maxSpeed);
    }
}
