package com.junpenghe.java.basic.polymophism.cleanup;

public class Characteristic {
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic" + s);
    }

    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}
