package com.junpenghe.java.basic.interfaces.abstracts.instrument;

class Brass extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }

    @Override
    String what() {
        return "Brass";
    }
}
