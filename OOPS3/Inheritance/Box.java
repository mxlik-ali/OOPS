package com.ali.OOPS3.Inheritance;

public class Box {
    double l;
    double h;
    double w;
    double weight;

    Box(){
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box(double side){
        super(); //note every class is inherited from object Class defined by java
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box(double l, double h, double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box other){
        this.l = other.l;
        this.h = other.h;
        this.w = other.w;
    }
}
/*
Calling the Parent Class Constructor with super():
    super(); is a call to the constructor of the parent class, which in this case is implicitly Object
    if Box does not explicitly extend any other class.In Java, all classes implicitly inherit from the
    Object class, the root class of the Java class hierarchy. This means that every class has access to
    methods defined in Object, such as toString(), equals(), hashCode(), and others.
Purpose of super():
    Calling super(); in the constructor ensures that any initialization logic defined in the parent class's
    constructor is executed.For the Object class, the default constructor doesn’t do much—it simply sets up
    the object’s internal structure. However, if Box had extended another class (other than Object), calling
    super(); would execute the parent class's constructor to ensure proper initialization.
    If you do not call super() explicitly, the Java compiler automatically inserts a call to the no-argument
    constructor of the superclass, which is equivalent to super();.

Preventing inheritance:-
    To prevent inheritance you can declare the class as final so that inheritance can be prevented
    public final class Box{

    }
    When you declare a clas final implicitly all its methods become final as well
 */
