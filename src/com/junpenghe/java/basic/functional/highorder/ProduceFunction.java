package com.junpenghe.java.basic.functional.highorder;

import java.util.function.Function;

/**
 * @author Junpeng He
 */

interface FuncSS extends Function<String, String> {}

public class ProduceFunction {
    static FuncSS produce() {
        return String::toLowerCase;
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }

}
