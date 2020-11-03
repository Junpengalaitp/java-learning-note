package com.junpenghe.java.basic.functional;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Junpeng He
 */
public class ISupplier {
    static Supplier<String> stringSupplier = () -> "String!";
    static Supplier<List<String>> listSupplier = () -> List.of("1", "2", "3");

    public static void main(String[] args) {
        String str = stringSupplier.get();
        System.out.println(str);
        List<String> list = listSupplier.get();
        System.out.println(list);
    }
}
