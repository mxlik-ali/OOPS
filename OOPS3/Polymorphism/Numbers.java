package com.ali.OOPS3.Polymorphism;

public class Numbers {
    int sum(int a, int b){
        return a+b;
    }
    int sum(int a, int b , int c){
        return a+b+c;
    }

    double sumBool(double a , int b){
        return a+b;
    }

    public static void main(String[] args) {
        Numbers num = new Numbers();
        num.sum(1,2);
        num.sum(3,4,5);
        num.sumBool(2,3); // Here tho the arg provided is an integer, tho you were supposed to provide double it does automatic type-casting
    }

}
    /*
    void order(String a, int b){

    }
    void order(int a, String b){

    }
    The above two functions will also not throw an error because the order of arguments is different

    But consider this case
    int sum(int a, int b){
        return a+b;
    }
    int sum(int b, int a){
        return a+b;
    }
    This will throw an error because bot the arguments are of same type int
     */

