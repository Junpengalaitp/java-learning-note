package com.junpenghe.java.basic.interfaces.Applicator;

public class Downcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
