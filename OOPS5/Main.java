package com.ali.OOPS5;

public class Main {
    public static void main(String[] args) {
        Son ali = new Son(20);
        ali.career();
        ali.partner();
        ali.normal();
        int value = ali.value;
        System.out.println(value);

        Daughter sana = new Daughter(24);
        sana.career();
        sana.partner();

        //Parent dad = new Parent(56); //This gives error as you cannot create objects of abstract class, The reason is stated below
        //lets say you can create an abstract class object so if you will call abstract methods through that abject it will give error
        Parent.greeting();
    }
}
