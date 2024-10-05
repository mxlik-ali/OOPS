package com.ali.OOPS2.Human;


public class Human {
    int age ;                // instance variable
    String name;            // instance variable
    int salary;             // instance variable
    boolean married;        // instance variable
    static long population = 1; // static variable shared by all instances
                            // static var are not dependent on objects , you can even access them without creating any object

    // Constructor to initialize instance variables and update population
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;

        // Increase population count by 1 every time a new object is created
        Human.population += 1;
        //here you can even write this.population in this case the constructor checks if there is any object variable named
        //population it finds none then it checks if any class variable is present named population
    }

    public static void main(String[] args) {
    /*
    The main method is static because it serves as the entry point of the program.
    Since no objects exist when the program starts, a static method can be called
    directly by the JVM without needing to create an instance of the class.
    If main were non-static, an object would have to be created first, which isn't
    feasible since the program would have no way to initiate the object creation.
    */
    }

    static void greeting(){
        System.out.println("hello World");
        //System.out.println(this.age); you cannot do this because since static method is not
        // dependent on object how can its property be dependent on obj
    }
}
/*
The instance variables (age, name, salary, and married) are specific to each Human object.
The static variable population is shared across all objects of the Human class, meaning there
is only one copy of population for the entire class, regardless of how many Human objects are created.

Key Concepts:
    Instance Variables:
        Each object has its own copy of the instance variables. For example, ali has its own age, name, salary,
        and married values, which are distinct from sagar's values.

    Static Variable (population):
        This variable is shared across all objects of the class. It is incremented every time a new Human object
        is created, so it always reflects the total number of Human objects created.
 */