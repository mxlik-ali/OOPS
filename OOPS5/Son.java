package com.ali.OOPS5;

public class Son extends Parent{

    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Im going to be a coder");
    }

    @Override
    void partner() {
        System.out.println("I love Messi");
    }
}
