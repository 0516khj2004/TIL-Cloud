package com.example.day3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        String[] names = {"a","b","c","e","d"};

        for(String name: names){
            System.out.print(name + "\t");
        }
        Arrays.sort(names);


        for(String name: names){
            System.out.print(name + "\t");
        }

    }
}
