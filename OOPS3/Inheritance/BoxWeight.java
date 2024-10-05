package com.ali.OOPS3.Inheritance;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = -1;
    }
    BoxWeight(double side,double weight){
        super(side);
        this.weight = weight;
    }

    BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }
    BoxWeight(double l, double h, double w, double weight){
        super(l,h,w); // what is this? this statement calls the parent class constructor
                      // used to initialize values present in parent class
                      // super has to be declared first then carry out this.weight = weight or else it will give error (read below)


        //System.out.println(super.w); // super keyword is also used to access the properties of parent class
        //System.out.println(this.w); // This will also fetch us the parent class properties but confusion asises
        //when both the parent and the child class share a same property field name lets take weight in both classes as a class field

        //System.out.println(super.weight); //this will fetch us the parent class weight attribute
        this.weight = weight;
    }
}
/*
Object Construction Hierarchy:
    In an inheritance hierarchy, when you create an instance of a subclass (child class), the Java runtime must
    first construct the parent class (superclass) before constructing the child class.
    This is because the subclass can rely on fields and methods from its parent class, so the parent class must
    be initialized properly before the subclass can be fully constructed.
    If the parent class's fields or methods are not initialized, the child class might not behave correctly.

Calling super() Ensures Proper Initialization:
    The super() call invokes the constructor of the parent class. This ensures that all fields and methods from
    the parent class are initialized properly before you start initializing the fields in the child class.
    If you don’t explicitly call super(), the Java compiler automatically inserts a call to the no-argument constructor of
    the parent class at the start of the subclass constructor. So, even if you don’t see it, the parent class is always constructed first.
 */
