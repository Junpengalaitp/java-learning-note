package com.junpenghe.java.basic.functional.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Junpeng He
 */
public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }
}
