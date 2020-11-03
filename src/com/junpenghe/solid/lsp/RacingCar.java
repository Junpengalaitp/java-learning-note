package com.junpenghe.solid.lsp;

public class RacingCar extends Vehicle {

    @Override
    public double getInteriorWidth() {
        return this.getCockpitWidth();
    }

    public double getCockpitWidth() {
        return 0;
    }
}
