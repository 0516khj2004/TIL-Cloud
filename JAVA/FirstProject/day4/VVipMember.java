package com.example.day4;

import java.util.Date;

public class VVipMember extends Member implements IMemberFunc{
    public VVipMember(String id) {
        this.id = id;
        this.grade = "V1";
        this.joinDate = new Date();
    }

    @Override
    public void setPoint(int point){
        this.point = point*0.8;
    }

    @Override
    public  boolean isAuthorized(){
        return true;
    }

    @Override
    public void display() {
        System.out.println("#################################");
        System.out.printf("%s, %s, %s , %s \n", super.id, super.grade, super.point, super.joinDate);
        System.out.println("#################################");
    }
}
