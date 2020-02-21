package com.example.day1;


public class HelloWorld{
    public static void main(String[] args) {
        System.out.println("Hello World");

        int a =10;
        float pi = 3.14f;  //실수형은 기본 double형 데이터 이기 때문에 오류가 나는 것
        System.out.println( a* a* pi);

        int intValute = 65;
        char charValue = (char) intValute;
        System.out.println(charValue);

        double dValute = 3.14;
        int iValute = (int) dValute;
        System.out.println(iValute);

        String kor  = "85.5";

        float total = 0.0f;
        total += Float.parseFloat(kor);

        System.out.println("kor= " + kor);


    }
}