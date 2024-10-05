package com.ali.OOPS4.access;

public class Main {
    public static void main(String[] args) {
        A obj = new A(2,"Sagar",new int[5]);

        //int a = obj.num; // This gives you the error because the instance variable num is set to private

        obj.setNum(4); // Using setters to access the num variable and initialize it with another value
        int a = obj.getNum(); //Using getters to access the num variable value
        System.out.println(a);

        int b = obj.numpublic; // Accessing public instance variable, since numpublic is public you can access it
                                // from any package or within the current package
        System.out.println(b);

        String name = obj.name; //here you can access the default type access modifier variable (see access2 main file)

        String name2 = obj.name2;// here you can access the protected type access modifier variable

    }
}
