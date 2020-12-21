package com.junpenghe.solid.isp.before;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CannonPrinter implements IMultiFunction {
    @Override
    public void print() {

    }

    @Override
    public void getPrintSpoolDetails() {

    }

    @Override
    public void scan() {
        System.out.println("error, do not support this function");
    }

    @Override
    public void scanPhoto() {
        System.out.println("error, do not support this function");
    }

    @Override
    public void fax() {
        System.out.println("error, do not support this function");
    }

    @Override
    public void internetFax() {
        System.out.println("error, do not support this function");
    }

    Map<Integer, Integer> map = IntStream.range(0, 10).boxed().collect(Collectors.toMap(i -> i, i -> i));
}
