package com.ali.OOPS2.Human;

import static com.ali.OOPS2.Human.Singleton.isInstance;

public class SingletonAccess {
    public static void main(String[] args) {
        Singleton obj = Singleton.isInstance();
        Singleton obj2 =  Singleton.isInstance();
        Singleton obj3 =  Singleton.isInstance();

    }
}
