package com.ali.OOPS3.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        circle.area(); // this will print "Area is pi * r * r", Basically since the object created is of type Circle

        Shape circle2 = new Circle();
        circle2.area(); // this will also print "Area is pi * r * r",since object created is of type circle (constructor used is of type circle)

        circle2.greeting(); //here even tho you tried to override the greeting method and expected the one in Circle class to execute
                            // the one inside Super-class executed
                            // Whenever you make your method static in clas you know that it can be accessed even without
                            // creating any object so basically internally it works Shape.greeting()
                            // static methods dont depend on objects, overriding depends upon the type of object created
                            // (weather parent obj or child object). Hence, here overriding do not occur
                            // refer below
    }
}
/*
There are two types of Polymorphism namely:-
=> Compile time/ static polymorphism (Numbers file)
        This basically happens when we do method overloading see Numbers file,
=> Runtime / dynamic polymorphism
        This basically happens when we do method overriding, It means when both the parent and the child class
        has the same method with the same name and same arguments see Shapes e.g.

Overriding
    Shape circle2 = new Circle();
    Try to understand how this works
    Basically the object when its declared (left hand side) gives you access to all the properties and method defined inside that class
    So when circle2.area is called during compilation it checks weather area method is present in Shape class or not
    Since it is present it doesn't give any error

    But during runtime java uses something known as Dynamic Memory Dispatch and since the object formed is dur to constructor Circle
    it run the method defined under Circle

    Note :- If there is no area method in Shape class it will lead to error during compilation time only,
    this basically brings you to the topic taught to u in inheritance where u cannot access child class properties if declaration is of type parent class

Static Method Overriding:-
    Even though circle2 is referencing an object of type Circle, the greeting() method is static. Static methods are
    resolved at compile-time and are based on the reference type, which is Shape in this case.
    This means the greeting() method of the Shape class will be called, not the greeting() method of the Circle class.
    Output: "Hello im in Shape Class"

Why Static Methods Don’t Get Overridden:
    Static methods are class-level methods and do not participate in dynamic method dispatch (which is used for method overriding).
    Therefore, when you call a static method, the method associated with the reference type (in this case Shape) is invoked,
    regardless of the object type (Circle).

 */