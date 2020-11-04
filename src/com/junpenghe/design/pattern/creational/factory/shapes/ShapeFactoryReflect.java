package com.junpenghe.design.pattern.creational.factory.shapes;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Junpeng He
 */
public class ShapeFactoryReflect implements FactoryMethod {
    Map<String, Constructor> factories = new HashMap<>();

    static Constructor load(String id) {
        System.out.println("loading " + id);
        try {
            String name = "com.junpenghe.design.pattern.creational.factory.shapes." + id;
            return Class.forName(name).getConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new BadShapeCreation(id);
        }
    }

    @Override
    public Shape create(String id) {
        try {
            return (Shape) factories
                    .computeIfAbsent(id, ShapeFactoryReflect::load)
                    .newInstance();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new BadShapeCreation(id);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactoryReflect());
    }
}
