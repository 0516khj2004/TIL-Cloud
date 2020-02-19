package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        String  hello = "Hello";
        String  world = "world";
        String  name = "Hello";
        String  newname = new String("Hello");


        name = null;
//        System.out.println(name + "/" + name.length());
//        System.out.println(newname + "/" + newname.length());
//        System.out.println(hello == name);
//        System.out.println(newname == name);
//        System.out.println(newname.equals(name));

        System.out.println(name);
        System.out.println(name.length());

    }
}
