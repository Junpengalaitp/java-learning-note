package com.junpenghe.java.basic.functional.programming;

import javax.xml.crypto.dsig.Transform;

/**
 * @author Junpeng He
 */

class X {
    String f() {
        return "X()::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
//        MakeString ms = X::f;
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }
}
