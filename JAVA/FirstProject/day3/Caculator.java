package com.example.day3;

public class Caculator {
    int add(int x, int y){
        return x+y;
    }
    double add(double x, double y){
        return x+y;
    }
//    int add(int[] x){
//        int sum =0;
//        for (int i=0; i<x.length; i++){
//            sum += x[i];
//        }
//        return sum;
//    }
    int add(int...value){
        int result = 0;
        for (int i : value) {
            result += i;
        }
        return result;
    }
    int subtract(int x, int y){
        return x-y;
    }
    int multiply(int x, int y){
        return x*y;
    }
    int divide(int x, int y){
        return x / y;
    }
}
