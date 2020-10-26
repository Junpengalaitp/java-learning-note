package com.junpenghe.java.basic.polymophism.design;

/**
 * Use inheritance to express differences in behavior, and fields to express variations in state.
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
