package com.example.day1;

import java.util.Scanner;

public class Input1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("국어점수 : ");
        int kor = s.nextInt();
        System.out.println("수학점수 : ");
        int eng =s.nextInt();
        System.out.println("수학점수 : ");
        int mat= s.nextInt();

        int total = kor + eng + mat;
        float avg = total / 3.0f;

        String result1 = String.format("총점:%s, 평균:%s" ,total,avg);
        String result2 = String.format("총점:%s, 평균:%.2f" ,total,avg);
        System.out.println(result1);
        System.out.println(result2);

    }
}
