package com.example.day3;
public class Demo1 {
    public static void main(String[] args) {
        Caculator calc = new Caculator();
        int result = calc.add(10, 5);
        System.out.println(result);
        double result2 = calc.add(10.1,20.1);
        System.out.println(result2);

        int x =10;
        int y = 40;
        int result3 = calc.add(x,y);
//        System.out.printf("%s, %s, %s" ,x,y,result3);
//        System.out.println();
//        int[] sum = {100,200,300,400};
//        int result4 = calc.add(sum);
//        sum = new int[]{500,700,900,300};
//        int result5 = calc.add(sum);
//        System.out.println(result4);
//        System.out.println(result5);
        System.out.println(calc.add(1,2,3));
        System.out.println(calc.add(1,2,3,5,6));
        System.out.println(calc.add(1,2,3,5,6,4));
    }
}
