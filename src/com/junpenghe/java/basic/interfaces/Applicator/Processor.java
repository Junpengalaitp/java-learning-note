package com.junpenghe.java.basic.interfaces.Applicator;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}
