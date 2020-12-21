package com.junpenghe.java.basic.functional.highorder;

import java.util.function.Function;

/**
 * @author Junpeng He
 */

class One {
}

class Two {
}

public class ConsumerFunction {
    static Two consume(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
