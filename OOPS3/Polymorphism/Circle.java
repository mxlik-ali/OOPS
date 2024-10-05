package com.ali.OOPS3.Polymorphism;

public class Circle extends Shape{
    //this will run when  obj of circle is created
    //hence it is overriding the parent method

    @Override //this is called annotation where it specifies that yes methods override
    void area(){
        System.out.println("Area is pi * r * r");
    }
//    @Override this gives an error because static void greeting is present in Shape super-class
    static void greeting(){
        System.out.println("Hello im in Circle class");
    }
}
