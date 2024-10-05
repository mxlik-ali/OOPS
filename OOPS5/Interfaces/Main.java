package com.ali.OOPS5.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car porshe = new Car();
        porshe.deceleration();
        porshe.start();

        Media Ferrari = new Car();
        Ferrari.start(); //Here also it prints for the engine, but then its problem lets say you want to start media player u wil start the engine

        NiceCar newcar = new NiceCar();
        newcar.start();
        newcar.startMedia(); // now we can access all the players and engines differently and our above problem is solved
        newcar.upgradeEngine();
        newcar.start();
    }
}
