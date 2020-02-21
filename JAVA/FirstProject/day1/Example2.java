package com.example.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example2 {
    public static void main (String[] args){
        int a = 10;
        int b = 20;
        int x = a++ + ++b;
        System.out.println(a + " ," + a++ + " ,"  + ++b + " ,"+ x);

        String name ="koo";
        List list1 = new ArrayList();
        Collection list2 = new ArrayList();

        System.out.println(list1 instanceof List);
        System.out.println(list1 instanceof Collection);


        System.out.println(list2 instanceof List);
        System.out.println(list2 instanceof Collection);


        long startTime = System.nanoTime() ;
        String str = "A";
        for (int i =0 ; i < 100_000; i++){
            str += "A";
        }
        long endTime = System.nanoTime();
        System.out.println("(string)Elapsed time: " + (endTime - startTime));

        startTime = System.nanoTime() ;
        StringBuilder sb = new StringBuilder("A");
        String s1 = new String("A");
        String s2 = "A";
        int o =100;
        for (int i =0 ; i < 100_000; i++){
            sb.append("A");
        }
        endTime = System.nanoTime();

        System.out.println("(s) StringBuilder time: " + (endTime - startTime));


    }
}
