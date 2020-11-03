package com.junpenghe.java.basic.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Junpeng He
 */
public class IFunction {

    static Function<Integer, Integer> incrementOne = num -> num + 1;

    static BiFunction<Integer, Integer, Integer> incrementOneAndMultiply = (num, x) -> (num + 1) * x;

    public static void main(String[] args) {
        int i = 0;
        i = incrementOne.apply(i);
        i = incrementOneAndMultiply.apply(i, 100);
        System.out.println(i);
    }
}
