package com.example.day3;

import com.example.day2.Student;

import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getSum() > s2.getSum()){
            return -1;
        }else if(s1.getSum() < s2.getSum()){
            return 1;
        }else {
            return s1.getName().compareTo(s2.getName());
        }

    }
}

public class SungjukAppV2 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
            new Student("aaa", 85, 29, 40),
            new Student("bbb", 100, 100, 80),
            new Student("ccc", 85, 93, 58),
            new Student("ddd", 100, 100, 100),
            new Student("eee", 29, 99, 40)
        };

//        for(Student student : students){
//            System.out.println(student);
//        }

//        System.out.println(students[0].e후quals(students[1]));    // 재정의 되어있음
//        System.out.println(students[0] == students[1]);         // 주소가 다르기 때문에 false
        System.out.println("================정렬전=================");
        for (Student stu : students) {
            System.out.println(stu);
        }

        System.out.println("================정렬후=================");
        Arrays.sort(students, new MyComparator());

        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}
