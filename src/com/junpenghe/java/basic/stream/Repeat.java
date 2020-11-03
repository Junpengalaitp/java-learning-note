package com.junpenghe.java.basic.stream;

import java.util.stream.IntStream;

/**
 * @author Junpeng He
 */
public class Repeat {
    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }
}
