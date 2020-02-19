package com.example.day2;

public class Demo2 {
    public static void main(String[] args) {
//        int [] scores = { 1,2,3,4,5,6,7};
//        System.out.println(scores.length);
//
//        System.out.println(scores[0]);
//        System.out.println(scores[6]);
////        System.out.println(scores[7]);
//
//        String[] name = {"a","b","c","d","e"};
//
//        System.out.println(name[0]);
//        System.out.println(name.length);
//        System.out.println(name[1]);
//        name[4] = "java";
//        System.out.println(name[4]);

        String[] names = new String[]{"a","b","c"};
        int [] scores ;
//        scores = {1,2,3,4,5,6};
        scores = new int[] {1,2,3,4,5,6};

        String[] animals = new String[5];
        animals[4] = "cat";
        animals[3] = new String("dog");
        animals[2] = new String("dog3");
        animals[1] = new String("dog2");
        animals[0] = new String("dog1");


//        for (int i=0; i< animals.length; i++){
//            System.out.println(i + ":" + animals[i]);
//        }
        int index = 0;
        for(String a : animals){
            System.out.println(index++ + ":" + a);
        }

        double[] d = new double[5];
        d[0] = 0.0;  //8:8
        d[1] = 3.14f; //8:4
        d[2] = 100; //8:4
        d[3] = 2_200_000_000L; //8:8
        d[4] = 'A';  //8:2

        for (double _d : d) {
            System.out.println(_d);

        }

    }
}
