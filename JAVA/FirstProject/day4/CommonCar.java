package com.example.day4;

public abstract class CommonCar {
     protected String brandName;
     protected String carName;
     protected Engin engin;

     public CommonCar(){
         System.out.println("Parent Class");
         this.brandName = "(현대자동차)Hyundai";
         this.engin = new Engin();
     }

     public  abstract void  displayInfo();
}
