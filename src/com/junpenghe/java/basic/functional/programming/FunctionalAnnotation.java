package com.junpenghe.java.basic.functional.programming;

import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Junpeng He
 */
public class FunctionalAnnotation {
    public String goodBye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodBye;
        FunctionalNoAnn fna = fa::goodBye;
//        Functional fac = fa;
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }
}

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

//@FunctionalInterface
//interface NotFunctional {
//    String goodbye(String arg);
//    String hello(String arg);
//}