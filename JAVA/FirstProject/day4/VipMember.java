package com.example.day4;

import java.util.Date;

public class VipMember extends Member implements IMemberFunc {
    public VipMember(String id, String grade) {
        this.id = id;
        this.grade = grade;
        this.joinDate = new Date();
    }

    @Override
    public void setPoint(int point){
        this.point = point*0.5;
    }

    @Override
    public boolean isAuthorized(){
        return true;
    }

    @Override
    public void display() {
        System.out.println("*******************************************");
        System.out.printf("%s, %s, %s , %s \n", super.id, super.grade, super.point, super.joinDate);
        System.out.println("*******************************************");
    }
}
