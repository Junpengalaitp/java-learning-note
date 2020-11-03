package com.junpenghe.java.basic.functional.closure;

import java.util.function.IntSupplier;

/**
 * @author Junpeng He
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}
