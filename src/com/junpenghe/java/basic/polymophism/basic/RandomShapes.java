package com.junpenghe.java.basic.polymophism.basic;

import java.util.Random;

public class RandomShapes {
    private Random random = new Random(47);

    public Shape get() {
        switch (random.nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            default:
                return new Shape();
        }
    }

    public Shape[] array(int sz) {
        Shape[] shapes = new Shape[sz];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }
}
