package com.junpenghe.solid.lsp;

public class InHouseProduct extends Product {
    public void applyExtraDiscount() {
        discount = discount * 1.5;
    }

    @Override
    public double getDiscount() {
        this.applyExtraDiscount();
        return discount;
    }
}
