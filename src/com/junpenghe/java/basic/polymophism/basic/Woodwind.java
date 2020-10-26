package com.junpenghe.java.basic.polymophism.basic;

public class Woodwind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Woodwind.play()" + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Woodwind");
    }
}
