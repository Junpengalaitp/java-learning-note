package com.junpenghe.java.basic.stream;

import static com.junpenghe.java.basic.stream.Repeat.repeat;

/**
 * @author Junpeng He
 */
public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!"));
        repeat(2, Looping::hi);
    }
}
