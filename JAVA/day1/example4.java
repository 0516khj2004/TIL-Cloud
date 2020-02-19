package com.example.day1;

import java.util.ArrayList;
import java.util.Scanner;

public class example4 {
    public static void main(String[] args) {
        int lineNumber =1 ;
        int count =0;
        ArrayList result = new ArrayList();
        for (int i = 1; i<=107; i++){
            int sum = 0;
            for (int x =2; x<=i; x++){
                if(i % x == 0 ){
                    sum++;
                }
            }
            if (sum == 1 ){
                System.out.print(i + "\t");
                count++;
            }
            if(lineNumber == count){
                System.out.println();
                lineNumber++;
                count =0;

            }
        }


    }
}
