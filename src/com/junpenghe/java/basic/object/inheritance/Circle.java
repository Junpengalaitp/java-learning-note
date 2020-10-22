package com.junpenghe.java.basic.object.inheritance;

public class Circle extends Shape {

    private String color = "circleColor";

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

    /**
     * overrides parents get color, other wise it will get parent color
     */
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
