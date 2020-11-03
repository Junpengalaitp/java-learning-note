package com.junpenghe.java.basic.stream;

import java.util.stream.Stream;

/**
 * @author Junpeng He
 */
public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
