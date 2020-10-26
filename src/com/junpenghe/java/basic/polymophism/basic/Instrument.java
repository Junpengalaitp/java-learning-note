package com.junpenghe.java.basic.polymophism.basic;

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()" + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}
