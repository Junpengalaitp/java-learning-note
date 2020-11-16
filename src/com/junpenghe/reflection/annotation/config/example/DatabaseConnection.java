package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.config.example.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.config.example.annotation.InitializerMethod;

/**
 * @author Junpeng He
 */
@InitializerClass
public class DatabaseConnection {
    @InitializerMethod
    public void connectToDatabase1() {
        System.out.println("Connecting to database 1");
    }
    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }
}
