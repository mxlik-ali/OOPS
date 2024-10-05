package com.ali.OOPS2.Human;

public class Main {
    public static void main(String[] args) {

        System.out.println(Human.population);
        // static variables are not dependent on any object as it is independent of objects and can be accessed even before object creation

        // Create the first Human object
        Human ali = new Human(20, "Mohammed Ali", 100000, false);

        // Create the second Human object
        Human sagar = new Human(21, "Sagar Jhanjhoted", 100001, false);

        // Accessing the static variable 'population' through the object reference
        System.out.println(ali.population);  // Outputs: 2

        // Accessing the static variable 'population' through another object reference
        System.out.println(sagar.population);  // Outputs: 2

        // Accessing the static variable 'population' through the class name (correct approach)
        System.out.println(Human.population);  // Outputs: 2

        Main obj2 = new Main();
        obj2.fun2(); //See how here we need to create an object for a non-static method fun, so basically this is the reason w
                     // refer fun2 method
    }
    // this is not dependent on object
    static void fun(){
        //greeting();// here if the function is static itself it cant call a non-static method inside it
                   // you cant use this because it req an instance, but the function you are using it in does not depend on instance

        //you cannot access non static stuff without referencing their instances in a static context
        Main fun = new Main();
        fun.greeting(); //now you can access the greeting method by creating an instance
    }

    //we know that something which is not static, belongs to an object (this is dependent on object)
    void greeting(){
        System.out.println("Hello World");
    }

    void fun2(){
        greeting(); //here you can call the non-static method within a non-static method without creating an object
                    //because it knows that whenever fun2 method will be called an object will be created
                    // => every non-static method is called inside a static method(main) to be executed
    }
}
/*
Object Creation and population Static Variable:
    When you create the first object ali = new Human(...), the constructor runs, setting ali's instance variables
    (age, name, salary, and married) and incrementing Human.population by 1. Initially, the static population is 0, so after creating ali, Human.population becomes 1.
    When you create the second object sagar = new Human(...), the constructor runs again, incrementing Human.population by another 1, so now Human.population becomes 2.

Accessing population:
    Accessing through ali.population:
        This is technically valid, but it’s not recommended because population is static and belongs to the class itself.
         When you access ali.population, it still refers to Human.population, so it prints 2.
    Accessing through sagar.population:
        Similarly, this also refers to Human.population, so it again prints 2.
    Accessing through Human.population:
        This is the correct and preferred way to access static variables because population belongs to the class itself,
        not individual objects. It also prints 2, showing that population is shared among all instances of the class.

Why Static Variables Should Be Accessed Via the Class:
    Static variables should always be accessed via the class name (e.g., Human.population) because they are class-level
    properties, not tied to any specific object. Accessing them through an object reference (like ali.population) can still work,
    but it’s less clear and can lead to confusion about the variable’s actual scope. The static variable doesn’t change
    based on which object is accessing it—there's only one copy for the entire class.
 */