package com.ali.OOPS4.access2;

import com.ali.OOPS4.access.A;
import com.ali.OOPS4.access.SubClass;

public class Main {
    public static void main(String[] args) {
        A obj = new A(4,"Ali",new int[4]);

        int b = obj.numpublic; // Accessing public instance variable, since numpublic is public you can access it
        // from any package or within the current package
        System.out.println(b);

        //String name = obj.name; //here you cannot access the default type access modifier variable (see Table)

        //String name2 = obj.name2;// here you cannot access the protected type access modifier variable (see Table)

        SubClass object = new SubClass(23,"object",new int[3]);
        //object.name //This will lead to error
    }
}
