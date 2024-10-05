package com.ali.OOPS5;

public abstract class Parent { //Any class having 1 or more abstract methods is declared as abstract
    int age;
    final int value;

    abstract void career();
    abstract void partner();

    static void greeting(){
        System.out.println("Hello, Hey there");
        //you can create static methods in abstract classes since abstract classes cannot create objects for themselves,
        // And static class isn't depended on any object creation to run
    }

    void normal (){
        System.out.println("This is a normal method"); //you can create methods like we previously did in normal classes
    }

    public Parent(int age) {
        this.age = age;
        value = 2345;
    }
    /*
    abstract public Parent(int age) {
        this.age = age;
    }
    You cannot create abstract constructors
    An abstract method is a method without implementation that forces subclasses to provide their own implementation. An abstract method is, by design, incomplete.
    A constructor, on the other hand, must always be concrete because its sole purpose is to initialize an object, which is a concrete operation.
    Abstract classes cannot be instantiated, and thus their constructors are only called indirectly via their concrete subclass constructors.
    However, the constructor itself needs to perform concrete tasks (like initializing fields), and thus cannot be abstract.

    You cannot have the parent class to be something like
    final public abstract class Parent{} because the final keyword prevents inheritance and abstract class is all about inheritance
     */
}
