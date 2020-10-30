package com.junpenghe.java.basic.interfaces.Applicator;

/**
 * The Applicator.apply() method takes any kind of Processor, applies it to an Object and prints the results.
 * Creating a method that behaves differently depending on the argument object you pass it is called the
 * Strategy design pattern. The method contains the fixed part of the algorithm, and the Strategy contains
 * the part that varies. The Strategy is the object you pass in, containing code. Here, the Processor object
 * is the Strategy, and main() shows three different Strategies applied to the String s.
 */
public class Applicator {

    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made on";
        apply(new Upcase(), s);
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }
}

