package com.ali.OOPS3.Polymorphism;

public class ObjectPrint {
    int num;

    public ObjectPrint(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ObjectPrint{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
        ObjectPrint obj = new ObjectPrint(54);
        System.out.println(obj); //before when you don't override the toString() method present inside
                                 // it will print com.ali.OOPS3.Polymorphism.ObjectPrint@6acbcfc0
                                 // basically here println calls valueof method inside and then it calls toString method
        //after when you create a toString method it will call the toString above method defined
    }
}
