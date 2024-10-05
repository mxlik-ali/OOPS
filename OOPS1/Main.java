package com.ali.OOPS1;

public class Main {
    public static void main(String[] args) {
        //store 5 roll no
        int[] rollno = new int[5];

        //store 5 names
        String[] names = new String[5];

        //now store for 5 students
        int[] rno = new int[5];
        String[] name = new String[5];
        int[] marks = new int[5];

        //but here as well it's not in the format we want
        //  the data to be stored in {rollno,name,marks} format so here we will have to create a data structure

        Student[] data = new Student[5];

        Student student1 ;
        /*
        here we declared a reference to the class Student, student1 is just a variable now
        here we can even say that the object student1 is instantiated
        student1 is inside the stack memory, but it isn't pointing to an object now in heap memory, since object is not initialized yet
        */


        student1 = new Student(); //here we are initializing the object
        /* NEW KEYWORD :-
            the new keyword here dynamically allocates memory during the runtime and returns a reference to it
            here in this case a reference of the object made in heap memory will be returned to reference variable student1
            Basically here it gives the memory address to ref var student1 (read documentation below in end)
        */

        Student kunal = new Student();


        System.out.println(kunal); //this will give you some random value
        System.out.println(kunal.rollno); // this give you default value 0
        System.out.println(kunal.name); //this give you default value null
        System.out.println(kunal.marks); //this gives you default value 0.0

        kunal.rollno = 1;
        kunal.name = "Kunal Khushwaha";
        kunal.marks = 97.5f;
        /*
        Dot operator:-
            In Java, the dot operator (.) is used to access members (fields, methods, and inner classes) of an object or a class.
            It allows you to refer to an object's attributes or invoke its methods.
         */

        System.out.println(kunal); //still gives some random value
        System.out.println(kunal.rollno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks); //above statements give you current value specified above

        //But the above way of specifying each and every object fields is a bit cumbersome,
        // and is there any way to allocate all the above values while we are creating the object

        //Student kunal2 = new Student();
        /*
        Here the student() is a constructor which is a special function, used to allocate some object fields or variables
        Whenever a new object is created it goes inside the constructor
         */


        kunal.greeting();
        kunal.changename("Sagar");
        System.out.println(kunal.name);

        Student random = new Student(kunal);
        System.out.println(random.rollno);
        System.out.println(random.name);
        System.out.println(random.marks);
    }
}
class Student{
    int rollno;
    String name;
    float marks;



//    Student (){
//        this.rollno = 13;
//        this.name = "Kunal Khushwaha";
//        this.marks = 87;
//    }
    /*
    This keyword:-
        in order to access the object inside the class the, this keyword is used
    */
    Student (){
        this(13,"default person",100);
        //this is how you call a constructor from another constructor
        //Internally it happens new Student (13,"default person",100);
    }

    void greeting(){
        System.out.println("Hello"+ " "+ this.name);
    }
    //here similarly this keyword is used to pass the reference to the object that is called above

    void changename (String naam){
        this.name = naam;
    }
    Student (int rno, String name, float marks){
        this.rollno = rno;
        this.name = name;
        this.marks = marks;
    }

    Student (Student other){ //here we are passing another object
        this.rollno = other.rollno;
        this.name = other.name;
        this.marks = other.marks;
    }
}

/*
CLASS:-
    It is a named group of properties and functions, we have three properties above rollno,name and marks if you want to combine them
    into one entity for a particular object for eg kunal you can do this via classes. CLASS is basically a set of rules and a template.

INSTANCE:-
    Instance of a class it is the physical object that is made out of a class

CLASS -> Logical construct (set of rules)
OBJECT -> physical reality (This is something that occupies space in memory)

Instance variables:-
    the variables of instances are know as instance variable
    lets say we make an object named student1 for the above class Student,
    Student student1 = new Student();
    sout(student1.rollno)

here the student1.rollno is instance variable

Dynamic Memory:-
    Lets take for eg
    Student student1 = new Student();

    Here the left hand part happens during the compile time
    Whilst the right hand side part happens during the runtime
    i.e during the runtime memory is allocated for the object created (student1 in this case)
    This is known as Dynamic memory allocation

Dot Operator:-
    Accessing Methods
    If you had methods in the Student class, for example:

    java
    Copy code
    class Student {
        int rollno;
        String name;
        float marks;

        void display() {
            System.out.println("Roll No: " + rollno);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);
        }
    }
    You could call the method using the dot operator like this:
    kunal.display(); This will invoke the display() method of the kunal object.

Constructor:-
    It is a special function, it basically defines what will happen when your object is going to be created
        class Student{
        int rollno;
        String name;
        float marks;

        Student (){
            kunal.rollno = 13;
            kunal.name = "Kunal Khushwaha";
            kunal.marks = 87;
        }
    }
    Lets say that we made a constructor by ourselves, and we want to assign the value for the object variables
    but if we directly use kunal.rollno/kunal.marks to assign the values for the object field this will lead to an error
    Lets say in future we create another object name rahul so the constructor will update the values for kunal instead of rahul hence
    we use here the, this keyword.

    Student (){
        this.rollno = 13;
        this.name = "Kunal Khushwaha";
        this.marks = 87;
    }


This keyword:-
        in order to access the object inside the class the, this keyword is used
        Internally when the below statement executes
            Student kunal = new Student();
        The object kunal is passed to constructor and then internally this takes place
            Student (){
            kunal.rollno = 13;
            kunal.name = "Kunal Khushwaha";
            kunal.marks = 87;
        }
        When we make an object named alice then instead of kunal alice will be replaced by this keyword internally.

=> Why don't we use new keyword for the primitive data types such as int, float?
        Ans - Primitive datatypes aren't considered as objects in java, unlike in python (everything is considered as objects)
              Primitives are stored in stack memory and not in heap, Reason java does this is to improve efficiency
 */

