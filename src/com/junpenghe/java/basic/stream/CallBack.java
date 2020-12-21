package com.junpenghe.java.basic.stream;

import java.util.function.Consumer;

/**
 * @author Junpeng He
 */
public class CallBack {

    static void hello(String firstName, String lastName, Consumer<String> callBack) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callBack.accept(firstName);
        }
    }

    public static void main(String[] args) {
        hello("John", null, v -> System.out.println("no last name provided for " + v));
    }
}
