package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.config.example.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.config.example.annotation.InitializerMethod;

/**
 * @author Junpeng He
 */
@InitializerClass
public class AutoSaver {
    @InitializerMethod
    public void startAutoSavingThreads() {
        System.out.println("Start automatic data saving to disk");
    }
}
