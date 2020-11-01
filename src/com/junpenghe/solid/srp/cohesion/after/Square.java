package com.junpenghe.solid.srp.cohesion.after;

public class Square {
    int side = 5;

    public int calculateArea() {
        return side * side;
    }

    public int calculatePerimeter() {
        return side * 4;
    }
}
