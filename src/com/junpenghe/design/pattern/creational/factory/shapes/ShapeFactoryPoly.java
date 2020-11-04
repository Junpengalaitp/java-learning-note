package com.junpenghe.design.pattern.creational.factory.shapes;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Junpeng He
 */

interface PolymorphicFactory {
    Shape create();
}

class RandomShapes implements Supplier<Shape> {
    private final PolymorphicFactory[] factories;
    private final Random rand = new Random(42);
    RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    @Override
    public Shape get() {
        return factories[rand.nextInt(factories.length)].create();
    }
}


public class ShapeFactoryPoly {
    public static void main(String[] args) {
        RandomShapes rs = new RandomShapes(
                Circle::new,
                Shape::new,
                Triangle::new
        );

        Stream.generate(rs)
                .limit(6)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();
    }
}
