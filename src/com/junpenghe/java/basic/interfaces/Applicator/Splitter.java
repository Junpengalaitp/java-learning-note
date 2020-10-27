package com.junpenghe.java.basic.interfaces.Applicator;

import java.util.Arrays;

public class Splitter extends Processor {
    @Override
    public String process(Object input) { // split() divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}
