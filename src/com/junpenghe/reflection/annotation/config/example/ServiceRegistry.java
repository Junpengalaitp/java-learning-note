package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.config.example.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.config.example.annotation.InitializerMethod;

/**
 * @author Junpeng He
 */
@InitializerClass
public class ServiceRegistry {
    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
