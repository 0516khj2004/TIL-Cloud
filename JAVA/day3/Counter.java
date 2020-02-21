package com.example.day3;

public class Counter {
    private static int count; // 공통변수 인스턴스 없이 사용 가능
    public static void addCount(){
        count++;
    }
    public static int getCount(){
        return  count;
    }
}
