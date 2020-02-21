package com.example.day3;

public class Demo4 {
    private static Demo4 obj = new Demo4();
    private  Demo4(){ }   // new
    public static synchronized Demo4 getInstance(){
        if(obj == null) {
            obj = new Demo4();
        }
       return obj;
    }
}
