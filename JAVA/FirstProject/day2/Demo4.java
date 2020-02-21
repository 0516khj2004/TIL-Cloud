package com.example.day2;

public class Demo4 {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        strArray[0] = "java 1.8";
        strArray[1] = "java 1.12";
        strArray[2] =  new String("java 1.13");

        String [] newArray = new String[10];
        System.arraycopy(strArray,0,newArray,0,strArray.length);
        for (String s : newArray) {
            System.out.println(s);
        }

//        System.out.println(strArray[0] == strArray[1]);
//        System.out.println(strArray[0] == strArray[2]);
//        System.out.println(strArray[0].equals(strArray[1]));
    }
}
