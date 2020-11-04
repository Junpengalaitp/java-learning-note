package com.junpenghe.design.pattern.creational.factory.shapes;

import java.util.stream.Stream;

/**
 * @author Junpeng He
 */
public class FactoryTest {
    public static void test(FactoryMethod factory) {
//        Stream.of("Circle", "Square", "Triangle", "Square", "Circle", "Circle", "Triangle")
//                .map(factory::create)
//                .peek(Shape::draw)
//                .peek(Shape::erase)
//                .count();
        FactoryMethod factoryMethod = new ShapeFactoryReflect();
        Stream.of("Circle", "Square", "Triangle", "Square", "Circle", "Circle", "Triangle").forEach(
                type -> {
                    Shape shape = factoryMethod.create(type);
                    shape.draw();
                    shape.erase();
                }
        );
    }
}
