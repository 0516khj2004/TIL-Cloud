package com.example.day2;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int[] comNumber = new int[6];
        Random rnd = new Random(System.currentTimeMillis());
        int index =0;
        while (true) {
            int _temp = rnd.nextInt(45) +1;
            boolean isDuplicated = false ;
            for(int preVal : comNumber){
                if(preVal == _temp){
                    isDuplicated = true;
                    break;
                }
            }
            if (isDuplicated){
                continue;
            }
            comNumber[index++] = _temp;
            if(index == 6){
                break;
            }
        }
        for (int i : comNumber) {
            System.out.print(i + "\t");
        }
        Scanner s = new Scanner(System.in);
        int[] userNumber = new int[6];
        for (int i=0; i<userNumber.length; i++) {
            userNumber[i] = s.nextInt();
        }
        int count =0;
        for (int comval : comNumber){
            for (int useVal : userNumber){
                if(comval == useVal){
                    count++;
                }
            }
        }
        System.out.println( count + "번 맞췄습니다");
    }
}
