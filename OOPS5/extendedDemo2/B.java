package com.ali.OOPS5.extendedDemo2;

public interface B extends A { //here for inheritance between interface extend keyword is used not implement
    void fun();
    static void greeting(){//static methods are allowed in interfaces, and static interface methods should always have a body
        // since interface is all about inheritance but static methods are not dependent on objects
        System.out.println("Hello");
    }
}
