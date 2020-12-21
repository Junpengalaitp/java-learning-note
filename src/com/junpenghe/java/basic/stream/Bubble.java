package com.junpenghe.java.basic.stream;

/**
 * @author Junpeng He
 */
public class Bubble {
    public final int i;

    public Bubble(int n) {
        i = n;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "i=" + i +
                '}';
    }

    private static int count = 0;

    Bubble bubble() {
        return new Bubble(count++);
    }
}
