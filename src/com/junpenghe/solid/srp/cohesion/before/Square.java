package com.junpenghe.solid.srp.cohesion.before;

public class Square {
    int side = 5;

    public int calculateArea() {
        return side * side;
    }

    public int calculatePerimeter() {
        return side * 4;
    }

    public void draw(boolean highResolutionMonitor) {
        if (highResolutionMonitor) {
            // render a high resolution image of a square
        } else {
            // render a normal image of a square
        }
    }

    public void rotate(int degree) {
        // Rotate the image of the square clockwise to the required degree and re-render
    }
}
