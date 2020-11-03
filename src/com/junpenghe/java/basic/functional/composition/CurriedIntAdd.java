package com.junpenghe.java.basic.functional.composition;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * @author Junpeng He
 */
public class CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> curriedIntAdd = a -> b -> a + b;
        IntUnaryOperator add4 = curriedIntAdd.apply(4);
        System.out.println(add4);
        System.out.println(add4.applyAsInt(5));
    }
}
