package com.example.day3;

public class Demo3 {
    public static void main(String[] args) {
//        Counter c1 = new Counter();
//        c1.count =c1.count +1;
//        c1.count =c1.count +1;
//        c1.count =c1.count +1;
//        System.out.println("c1 : " + c1.count);
//
//        Counter c2 = new Counter();
//        c2.count =c2.count +1;
//        c2.count =c2.count +1;
//        c2.count =c2.count +1;
//        System.out.println("c2 : " + c2.count);
//        System.out.println("c1 : " + c1.count);
//        Counter.count = Counter.count+1;
//        Counter c1 = new Counter();
//        c1.count =c1.count +1;
//        c1.count =c1.count +1;
//        c1.count =c1.count +1;
//        System.out.println("c1 : " + c1.count);
//
        Counter.addCount();
        Counter.addCount();
        Counter.addCount();
        Counter c1 = new Counter();
        System.out.println(c1.getCount());
        System.out.println(Counter.getCount());



    }
}
