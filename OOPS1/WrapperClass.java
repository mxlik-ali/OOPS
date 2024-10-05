package com.ali.OOPS1;

public class WrapperClass {


    public static void main(String[] args) {
        // Primitive data types
        int a = 10;
        int b = 20;

        // Wrapper class objects
        // Integer c = 10; uses auto-boxing, which internally works like Integer c = new Integer(10);
        // Auto-boxing allows primitive types to automatically convert to their corresponding wrapper class.
        // wrapper classes has more funtions available than primitive datatype
        Integer c = 10;
        Integer d = 20;

        // Attempt to swap the primitive integers a and b
        swapint(a, b);
        /*
         Output the values of a and b after attempting the swap
         You will notice here that a and b are not swapped.
         This happens because Java uses "pass by value" (even for objects),
         meaning it passes a copy of the value of the variables, not the variables themselves.
         Inside the swapint method, only the copies of a and b are swapped,
         but the original variables in main remain unchanged.
         */
        System.out.println(a + " " + b);  // Output: 10 20

        swapINT(c, d);
        System.out.println(c + " " + d); //here also the same thing happens

        final int bonus = 4;
        /*
        Final keyword:-
            when you use the final keyword infront of primitive datatypes you cant change it afterward once it is initialized
            This immutability for value is only true for primitive datatypes.
        bonus = 3; //This statement will give you error,


         */
        final A ali = new A("old obj");
        ali.name = "ali malik"; //this is allowed
        //ali = new A("new obj"); // when a non primitive is final you cannot reassign it

    }

    // This method tries to swap the values of two integers
    static void swapint(int a, int b) {
        // Swapping logic
        int temp = a;
        a = b;
        b = temp;

        // After this point, only the local copies of a and b inside this method are swapped.
        // The original variables from the calling method (main) remain unaffected.
    }

    static void swapINT(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
class A{
    final int num = 10;
    //here remember that once you use the final keyword you have to initialize the variable
    //you cannot just declare it and not initialize it
    String name;
    public A(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
/*
Final keyword for objects
    final Student kunal = new Student();
     kunal.name = "random name" is valid here
     kunal = other; is not valid since here you can change object fields but not the reference to the object


How to handle object cleanup now?
    1. Use try-with-resources for resource management:
        For objects that require cleanup (e.g., closing files or network connections), it's better to implement AutoCloseable and use the try-with-resources construct.

        java
        Copy code
        public class Resource implements AutoCloseable {
            @Override
            public void close() {
                System.out.println("Resource is cleaned up");
            }

            public static void main(String[] args) {
                try (Resource resource = new Resource()) {
                    // Use the resource
                } // Automatically calls resource.close() here
            }
        }


    2. Manual cleanup using a close() method:
        If automatic resource management is not an option, you can still create a close() method for manual cleanup.

        java
        Copy code
        public class Resource {
            public void close() {
                System.out.println("Resource is cleaned up");
            }

            public static void main(String[] args) {
                Resource resource = new Resource();
                try {
                    // Use the resource
                } finally {
                    resource.close();  // Manually clean up
                }
            }
        }
 */

