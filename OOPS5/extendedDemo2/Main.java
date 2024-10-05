package com.ali.OOPS5.extendedDemo2;

public class Main implements B ,A {
    @Override
    public void greet() {//whenever you inherit the method it should always have a better access modifier from parent class
        //In this case since A interface has this method as public by default here you cannont keep it private

    }

    @Override
    public void fun() {

    }
    //Here you have to override both the methods present in A,B

    public static void main(String[] args) {
        Main obj = new Main();
        B.greeting(); //Here using static method
    }

}
