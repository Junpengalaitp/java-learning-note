package com.junpenghe.java.basic.object.inheritance;

public class Square extends Shape {

    private String color = "squareColor";

    @Override
    public void draw() {
        System.out.println("child draw " + this.getClass().getSimpleName());
    }

    @Override
    public void erase() {
        System.out.println("child erase " + this.getClass().getSimpleName());
    }

    @Override
    public void move() {
        System.out.println("child move " + this.getClass().getSimpleName());
    }
}
