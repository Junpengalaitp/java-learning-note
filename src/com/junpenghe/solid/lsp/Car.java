package com.junpenghe.solid.lsp;

public class Car extends Vehicle {

    @Override
    public double getInteriorWidth() {
        return getCabinWidth();
    }

    public double getCabinWidth() {
        return 0;
    }
}
