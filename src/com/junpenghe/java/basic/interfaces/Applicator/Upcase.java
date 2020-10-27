package com.junpenghe.java.basic.interfaces.Applicator;

public class Upcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}
