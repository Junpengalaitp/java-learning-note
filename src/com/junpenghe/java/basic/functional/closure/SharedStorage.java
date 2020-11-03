package com.junpenghe.java.basic.functional.closure;

import java.util.function.IntSupplier;

/**
 * @author Junpeng He
 */
public class SharedStorage {
    public static void main(String[] args) {
        Closure closure = new Closure();
        IntSupplier f1 = closure.makeFun(0);
        IntSupplier f2 = closure.makeFun(0);
        IntSupplier f3 = closure.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}
