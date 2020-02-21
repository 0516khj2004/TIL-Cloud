package com.example.day3;

import java.util.Calendar;

public class Single {
    public static void main(String[] args) {
        Demo4 obj1 = Demo4.getInstance();
        Demo4 obj2 = Demo4.getInstance();
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj1 == obj2);

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
    }
}
