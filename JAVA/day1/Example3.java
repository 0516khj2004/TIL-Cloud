package com.example.day1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("숫자를 입력하세요  : ");
        int number1= s.nextInt();
        ArrayList result = new ArrayList();
        for (int i=1; i <=number1 ; i++){
            if(number1 % i == 0 ){
                result.add(i);
            }
        }
        System.out.println(result);







//        System.out.print("수학점수 : ");
//        int eng= s.nextInt();
//        System.out.print("영어점수 : ");
//        int mat = s.nextInt();
//
//        int total = kor + eng + mat;
//        int avg = total / 3;
//        int a = avg / 10 ;
//
//        switch (a)  {
//            case 10:
//            case 9:
//                System.out.println("A");
//                break;
//            case 8:
//                System.out.println("B");
//                break;
//            case 7:
//                System.out.println("C");
//                break;
//            case 6:
//                System.out.println("D");
//                break;
//            default:
//                System.out.println("F");
//                break;
//        }
    }
}
