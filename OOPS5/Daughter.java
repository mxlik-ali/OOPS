package com.ali.OOPS5;

public class Daughter extends Parent{

    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Im going to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Ronaldo");
    }
}
