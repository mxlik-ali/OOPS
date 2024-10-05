package com.ali.OOPS4.access2;

import com.ali.OOPS4.access.A;
import com.ali.OOPS4.access.SubClass;

public class SubClass2 extends A {
    public SubClass2(int num, String name, int[] arr) {
        // Using 'super' to call the constructor of the superclass (A)
        super(num, name, arr);
    }

    public static void main(String[] args) {
        // Creating an object of SubClass2, which is a subclass of A, in a different package
        SubClass2 obj = new SubClass2(3, "SubClass", new int[9]);

        // Trying to access 'name', which has 'no modifier' access level, will give an error since
        // 'name' is package-private (default) and we're in a different package
        // String name = obj.name; // Error: Cannot access package-private member outside the package

        // 'name2' has 'protected' access, so it can be accessed here because 'SubClass2' is a subclass of 'A'
        String name2 = obj.name2; // Works fine: Protected access allows access within the subclass

        // 'numpublic' is 'public', so it can be accessed from any package
        int num = obj.numpublic; // Works fine: Public access allows access from anywhere

        // Creating an object of type 'A' but referring to the subclass 'SubClass2'
        A obj2 = new A(34, "New Sb", new int[2]);


        /*
        Trying to access 'name2' (protected member) through 'obj2', which is of type 'A', will give an error.
        Even though 'name2' is protected, protected access only applies to objects made through subclasses,
        not the superclass reference. When you reference an object via its superclass type, the protected
        members are not accessible unless you're within the same package or directly in a subclass context.

        String String2 = obj2.name2; // Error: Cannot access protected member from superclass reference.

        Important: Protected gives access to subclasses, but only through subclass-type objects,
        not through superclass-type objects.
        */

        // Now, let's see what happens when we create an object of 'SubClass' (a class inside the same package as 'A')
        SubClass naya = new SubClass(23, "New object", new int[3]);

        // Attempting to access 'name' (which has no modifier) will still give an error because we are in a different package
        // String name = naya.name; // Error: Cannot access package-private member outside the package
    }
}

