package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.annotation.InitializerMethod;
import com.junpenghe.reflection.annotation.annotation.RetryOperation;

import java.io.IOException;

/**
 * @author Junpeng He
 */
@InitializerClass
public class DatabaseConnection {
    @RetryOperation(numberOfRetries = 10, retryExceptions = IOException.class, durationBetweenRetriesMs = 1000, failureMessage = "Connection to data base 1 failed after retries")
    @InitializerMethod
    public void connectToDatabase1() {
        System.out.println("Connecting to database 1");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }
}
