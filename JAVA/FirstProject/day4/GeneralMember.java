package com.example.day4;

import java.util.Date;

public class GeneralMember extends Member implements IMemberFunc{
    public GeneralMember(String id, String grade){
        this.id = id;
        this.grade =grade;
        this.joinDate = new Date();
    }
    @Override
    public void setPoint(int point){
        this.point = point * 0.3 ;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }

    @Override
    public void display() {
        System.out.printf("%s, %s, %s , %s \n", super.id, super.grade, super.point, super.joinDate);
    }
}
