package com.junpenghe.java.basic.interfaces.multipleInheritance;

public class MI implements One, Two, Three {
    public static void main(String[] args) {
        MI mi = new MI();
        mi.first();
        mi.second();
        mi.third();
        mi.something();
        mi.something(1);
        mi.somethingElse();
    }

    /**
     * conflicting methods must be Overridden
     */
    @Override
    public void somethingElse() {
        System.out.println("somethingElse()");
    }
}
