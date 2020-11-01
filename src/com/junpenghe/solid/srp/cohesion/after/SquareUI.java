package com.junpenghe.solid.srp.cohesion.after;

public class SquareUI {

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
