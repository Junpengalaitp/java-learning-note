package com.junpenghe.java.basic.interfaces.multipleInheritance;

public interface Two {
    default void second() { System.out.println("second"); }

    default void something(int i) {
        System.out.println("something()" + i);
    }

    default void somethingElse() {
        System.out.println("somethingElse()");
    }
}
