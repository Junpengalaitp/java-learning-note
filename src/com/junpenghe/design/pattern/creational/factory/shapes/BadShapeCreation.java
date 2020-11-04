package com.junpenghe.design.pattern.creational.factory.shapes;

/**
 * @author Junpeng He
 */
public class BadShapeCreation extends RuntimeException {
    public BadShapeCreation(String msg) {
        super(msg);
    }
}
