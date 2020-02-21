package com.example.day1;

public class Example5 {
    public static void main(String[] args) {
        int preNumber =1;
        int nextNumber =1;
        int currentNumber =1;
        int count = 0;

        while (currentNumber < 1000){
            currentNumber= preNumber + nextNumber;
            System.out.println(currentNumber);
            preNumber = nextNumber;
            nextNumber = currentNumber ;
            count ++;
        }

        System.out.println(count);

    }
}
