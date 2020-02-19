package com.example.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example6 {
    public static void main (String[] args){
       String name = "구현진";
       String hobby = "java";

       System.out.println(name == hobby);

       String name1 = "구현진";
       String name2 = "구현진";

       System.out.println(name2 == name1 );

       String newName1 = new String("구현진");
       String newName2 = new String("구현진");
       System.out.println(newName1 == newName2);

    }
}
