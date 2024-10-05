package com.ali.OOPS2.Human;

public class InnerClass {

    // Non-static inner class 'Test'
    class Test {
        String name;

        // Constructor to initialize 'name'
        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // The following will cause a compile-time error because 'Test' is a non-static inner class.
        // Non-static inner classes require an instance of the outer class (InnerClass) to be created first.
        // Without an instance of 'InnerClass', we cannot instantiate 'Test' directly.

        // Test a = new Test("Ali Malik");  // ERROR: Cannot reference a non-static inner class from a static context
        // Test b = new Test("Sagar Jhanjhoted");

        /*
        Non-static Inner Class: The Test class is a non-static inner class, meaning it depends on an instance
        of the outer class (InnerClass). This is why you can't create an instance of Test directly from a static
        context (like the main method).
         */

        // Correct way to instantiate the inner class 'Test':
        InnerClass outer = new InnerClass();  // Create an instance of the outer class
        Test a = outer.new Test("Ali Malik");  // Use the outer class instance to create the inner class instance
        Test b = outer.new Test("Sagar Jhanjhoted");

        // Now 'a' and 'b' are valid instances of the inner class 'Test'.
    }
}


class Test2 {
    static String name;

    // Constructor to initialize 'name'
    public Test2(String name) {
        Test2.name = name;
    }
}
class InnerClass2{
    public static void main(String[] args) {
        /*
        Here this will work totally fine because here the Test class though it is non-static isnt depending on any other outer class
         */
        Test2 a = new Test2("Ali Malik"); //here first this line sets static variable String to Ali
        Test2 b = new Test2("Sagar Jhanjhoted"); //then this line sets static variable String to Sagar

        System.out.println(a.name); // o/p Sagar
        System.out.println(b.name); // o/p Sagar

    }
}

class InnerClass3 {

    // Static inner class 'Test3'
    static class Test3 {
        String name; // Instance variable unique to each 'Test3' object

        // Constructor to initialize the 'name' field
        public Test3(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // Creating two separate instances of the static inner class 'Test3'.
        // Since 'Test3' is static, it does not require an instance of 'InnerClass3'.
        // Each object will have its own copy of the 'name' field.

        Test3 a = new Test3("Ali Malik");      // Object 'a' has name = "Ali Malik"
        Test3 b = new Test3("Sagar Jhanjhoted"); // Object 'b' has name = "Sagar Jhanjhoted"

        // Output will display the name for each respective object
        System.out.println(a.name); // Output: Ali Malik
        System.out.println(b.name); // Output: Sagar Jhanjhoted
    }
    /*
    In summary, even though Test3 is a static class, each instance (a and b) of Test3 has its own separate
    copy of the name field. Static inner classes can be instantiated without creating an instance of the
    outer class, but the instance variables are still unique to each object, which is why different values
    (Ali Malik and Sagar Jhanjhoted) are printed.
     */
}

