package com.example.day3;

import com.example.day2.Student;

public class SungjukApp2 {
    public static void main(String[] args) {
//        Student stu1 = new Student("aaa",100,95,96);
//        Student stu2 = new Student("bbb",50,96,96);
//        Student stu3 = new Student("ccc",70,76,66);
//        Student stu4 = new Student("ddd",78,44,51);
//        Student stu5 = new Student("eee",100,88,85);
//
//        stu1.calculate();
//        stu1.display();
//
        Student[] students = new Student[]{
                new Student("aaa",100,95,88),
                new Student("bbb",100,45,96),
                new Student("ccc",50,95,57),
        };

        for(int i=0; i<students.length; i++){
            students[i].calculate();
        }
        for (Student stu : students) {
           System.out.println(stu.toString());
        }
        System.out.println(students[0] == students[1]);
        System.out.println(students[0].equals(students[1])); // 둘이 같은 내용

    }
}
