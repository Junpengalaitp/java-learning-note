package com.junpenghe.java.basic.functional.closure;

import java.util.function.IntSupplier;

/**
 * @author Junpeng He
 */
public class Closure {
    int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}
