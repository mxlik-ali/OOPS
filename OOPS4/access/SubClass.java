package com.ali.OOPS4.access;

public class SubClass extends A{
    //constructor
    public SubClass(int num, String name, int[] arr) {
        super(num, name, arr);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(45,"Sachin",new int[5]);
        int b = obj.numpublic; // Accessing public instance variable, since numpublic is public you can access it
        // from any package or within the current package
        System.out.println(b);

        String name = obj.name; //here you can access the default type access modifier variable (see access2 main file)

        String name2 = obj.name2;// here you can access the protected type access modifier variable

        //Now try making an object of super class and then access the same variables
        // Here you are able to access these because this file and the super-class file is in same package
        // Hence even tho the object made is of type super-class, since all public , protected, and no modifier instance variables
        // give access for themselves to all the files inside the same pakage
        A obj2 = new A(23,"object",new int[3]);
        int c = obj2.numpublic; // Accessing public instance variable, since numpublic is public you can access it
                                // from any package or within the current package
        System.out.println(b);

        String nameClass = obj.name; //here you can access the default type access modifier variable (see access2 main file)

        String name2Class = obj.name2;// here you can access the protected type access modifier variable
    }
}
