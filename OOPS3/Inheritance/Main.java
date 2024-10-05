package com.ali.OOPS3.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        System.out.println(box1.l + " "+ box1.h+ " "+ box1.w);

        Box box2 = new Box(4);
        System.out.println(box2.l + " "+ box2.h+ " "+ box2.w);

        Box box3 = new Box(2,3,4);
        System.out.println(box3.l + " "+ box3.h+ " "+ box3.w);

        Box box4 = new Box(box2);
        System.out.println(box4.l + " "+ box4.h+ " "+ box4.w);

        BoxWeight box5 = new BoxWeight();
        System.out.println(box5.weight + " "+ box5.l);

        BoxWeight box6 = new BoxWeight(2,3,4,5);
        System.out.println(box6.l + " "+ box6.h+ " "+ box6.w + " "+ box6.weight );

        Box box7 = new BoxWeight(2,3,4,5);
        System.out.println(box7.w);
        //System.out.println(box7.weight); //This line will give you error
        /*
        Understand that box7 is a reference variable for type Box, so even though the object can be created here using
        BoxWeight constructor, it cannot possess the weight object filed , Since it is of type Class Box
        Basically the place where you declare the reference var i.e the left side, that decides the object properties that particular object will hold and not the constructor
         */


        //BoxWeight box8 = new Box(2,3,4); //Here we get an error
        /*
        There are many variables in both parents and child classes
        You are given access to variables(object fields) that are in the reference type (left hand side) i.e. Boxweight
        hence you should have access to weight variable
        But since you are using the constructor of Box class, weight is never initialized and hence you will not be able to access that object field
         */

    }
}
