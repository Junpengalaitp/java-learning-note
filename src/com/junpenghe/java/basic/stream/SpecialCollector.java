package com.junpenghe.java.basic.stream;

import java.util.ArrayList;

/**
 * @author Junpeng He
 */
public class SpecialCollector {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words = FileToWords.stream("Cheese.txt")
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
