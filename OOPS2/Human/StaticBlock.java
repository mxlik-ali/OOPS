package com.ali.OOPS2.Human;

public class StaticBlock {
    static  int a = 3;
    static  int b;

    //this will only run once when the first object is created for this class
    //i.e. when the class is loaded for the first time
    static {
        System.out.println("Im in static block");
        b = a * 5;
    }
    public static void main(String[] args) {
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // o/p will be 3,15

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // o/p will be 3,18

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // o/p will be 3,18 because the static block is only run once first obj is created for that class
    }
}
