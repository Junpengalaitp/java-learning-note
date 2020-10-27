package com.junpenghe.java.basic.interfaces.abstracts.instrument;

public class Percussion extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play()" + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
