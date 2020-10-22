package com.junpenghe.java.basic.object.inheritance;

public class Shape {

    public static String shapeString = "shapeString";

    private String color = "shapeColor";

    public void draw() {
        System.out.println("parent draw " + this.getClass().getSimpleName());
    }

    public void erase() {
        System.out.println("parent erase " + this.getClass().getSimpleName());
    }

    public void move() {
        System.out.println("parent move " + this.getClass().getSimpleName());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
