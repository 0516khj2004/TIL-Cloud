package com.example.day2;

public class Demo5 {
    public static void main(String[] args) {
       Member mem1 = new Member("java",10);   // 인스턴스 화 (mem1 은 인스턴스 혹은 객체라고 한다)
//       mem1.age =10;
//       mem1.name = "koo";
       mem1.displayInfo();
        Member mem2 = new Member("C++",15);
//        mem2.age =11;
//        mem2.name = "jung";
        mem2.displayInfo();
        Member mem3 = new Member("Python");
        mem3.displayInfo();

    }
}
