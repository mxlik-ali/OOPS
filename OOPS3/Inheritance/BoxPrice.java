package com.ali.OOPS3.Inheritance;

public class BoxPrice extends BoxWeight{

    double cost;

    public BoxPrice(double cost) {
        super();
        this.cost = cost;
    }

    public BoxPrice(BoxWeight other, double cost) {
        super(other);
        this.cost = cost;
    }

    public BoxPrice(double side, double weight, double cost) {
        super(side, weight);
        this.cost = cost;
    }

    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }
}
