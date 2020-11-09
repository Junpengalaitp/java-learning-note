package com.junpenghe.design.pattern.structural.visitor;

/**
 * @author Junpeng He
 */
public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
