package com.example.day2;

public class Member {
    //1.nested class
    class  VipMember{

    }
    //2.fields
    int age;
    String name;
    Project finalProject;   // 멤버와 프로젝트는 집합 관계 - member has a project
    Project semiProject;
    //3.methods
    void displayInfo(){
        System.out.println(String.format("이름은 %s이고 , 나이는 %s 입니다" , name,age));
    }
    //4.(optional) constructor method
    // 오버로딩 - 메소드의 이름은 같고, 파라미터의 타임이나 개수가 달라야 한다
    Member(String name, int age){
        this.name = name;
        this.age = age ;
    }
    Member(String name){
        this.name = name;
    }
}
class Project {
    String name;
    String period;
    void budget(){

    }
}
