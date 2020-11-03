package com.junpenghe.java.basic.functional;

import java.util.function.Consumer;

/**
 * @author Junpeng He
 */
public class IConsumer {

    static Consumer<Phone> consumer = phone -> System.out.println("operating system: " + phone.OS + ", brand: " + phone.brand);

    public static void main(String[] args) {
        consumer.accept(new Phone("IOS", "Apple"));
    }
}

class Phone {
    public String OS;
    public String brand;

    public Phone(String OS, String brand) {
        this.OS = OS;
        this.brand = brand;
    }
}
