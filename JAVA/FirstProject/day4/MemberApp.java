package com.example.day4;

public class MemberApp {
    public static void main(String[] args) {
        //추상클래스(abstract) 는 instance 생성 못함
        GeneralMember mem1 = new GeneralMember("user1", "A1");
        mem1.setPoint(100);
        mem1.display();

        VipMember mem2 = new VipMember("vip1", "S1");
        mem2.setPoint(100);
        mem2.display();

        VVipMember mem3 = new VVipMember("vvip1");
        mem3.setPoint(100);
        mem3.display();
    }
}
