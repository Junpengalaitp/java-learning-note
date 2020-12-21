package com.junpenghe.design.pattern.creational.factory.shapes;

/**
 * @author Junpeng He
 */
public class ShapeFactory implements FactoryMethod {
    @Override
    public Shape create(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                throw new BadShapeCreation(type);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactory());
    }
}
