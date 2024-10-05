package com.ali.OOPS5.Interfaces;

public class Car implements Brake,Engine,Media{
    @Override
    public void time() {
        System.out.println("Time taken to stop the car after Brake");
    }

    @Override
    public void deceleration() {
        System.out.println("Deceleration");
    }

    @Override
    public void start() {
        System.out.println("This is engine start");
    }

    @Override
    public void stop() {
        System.out.println("This is engine stop");
    }

    @Override
    public void model() {
        System.out.println("The model of ENgine is");
    }
}
