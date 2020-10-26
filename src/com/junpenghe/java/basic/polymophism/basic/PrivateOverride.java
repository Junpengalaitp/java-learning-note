package com.junpenghe.java.basic.polymophism.basic;

/**
 * only non-private methods can be overridden
 */
public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        PrivateOverrideTwo po2 = new DerivedTwo();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}

class PrivateOverrideTwo {
    private void f() {
        System.out.println("private f()");
    }
}

class DerivedTwo extends PrivateOverrideTwo {
    public void f() {
        System.out.println("public f()");
    }
}
