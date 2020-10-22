package com.junpenghe.java.basic.object.inheritance;

public class Triangle extends Shape {

    private String color = "triangleColor";

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

    public void flipVertical() {
        System.out.println("child flipVertical " + this.getClass().getSimpleName());
    }

    public void flipHorizontal() {
        System.out.println("child flipHorizontal " + this.getClass().getSimpleName());
    }
}
