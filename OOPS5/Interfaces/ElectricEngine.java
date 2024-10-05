package com.ali.OOPS5.Interfaces;

public class ElectricEngine implements Engine{

    @Override
    public void start() {
        System.out.println("The electric engine started");
    }

    @Override
    public void stop() {
        System.out.println("the Electric engine stopped");
    }

    @Override
    public void model() {
        System.out.println("Newest Electric engine model");
    }
}
