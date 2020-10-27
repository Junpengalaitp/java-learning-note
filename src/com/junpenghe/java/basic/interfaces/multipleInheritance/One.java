package com.junpenghe.java.basic.interfaces.multipleInheritance;

public interface One {
    default void first() { System.out.println("first"); }

    default void something() {
        System.out.println("something()");
    }

    default void somethingElse() {
        System.out.println("somethingElse()");
    }
}
