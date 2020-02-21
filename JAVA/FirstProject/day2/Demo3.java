package com.example.day2;

public class Demo3 {
    public static void main(String[] args) {
//       int [][] scores = new int[2][];
//
//        int [] scores[] = new int[2][3];
//        scores[0] = new int[3];
//        scores[1] = new int[4];
//
//        scores[0][0] = 100;
//        scores[0][1] = 200;
//        scores[0][2] = 300;
//
//        scores[1][0] = 400;
//        scores[1][1] = 500;
//        scores[1][2] = 600;
//        scores[1][3] = 700;

        int [][] scores = {{1,2,3}, {4,5,6}};
        int [][][] school = {
                {{1,2,3}, {4,5,6}},
                {{1,2,3}, {4,5,6}},
                {{1,2,3}, {4,5,6}}
        };
        for(int i=0; i<scores.length; i++){
            for(int x=0 ; x<scores[i].length; x++){
//                System.out.print("["+ i +"]"+"["+x+"]="+scores[i][x]+"\t" );
                System.out.print(String.format("[%s][%s]=%s\t", i,x,scores[i][x]));
            }
            System.out.println();
        }
        int index = 0;

        for (int[] i : scores) {
            for (int x : i) {
                System.out.print(x + "\t");
            }
            System.out.println();

        }
    }
}
