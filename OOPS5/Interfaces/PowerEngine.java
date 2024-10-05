package com.ali.OOPS5.Interfaces;

public class PowerEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Power engine start");
    }

    @Override
    public void stop() {
        System.out.println("Power engine stop");
    }

    @Override
    public void model() {
        System.out.println("Power Engine new model");
    }
}
