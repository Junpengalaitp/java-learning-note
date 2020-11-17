package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.annotation.InitializerMethod;

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
