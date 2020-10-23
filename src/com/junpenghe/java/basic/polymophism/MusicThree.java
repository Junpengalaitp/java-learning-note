package com.junpenghe.java.basic.polymophism;

public class MusicThree {
    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(orchestra);
    }

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }
}
