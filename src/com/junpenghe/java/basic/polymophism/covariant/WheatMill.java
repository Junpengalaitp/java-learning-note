package com.junpenghe.java.basic.polymophism.covariant;

public class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}
