package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.annotation.InitializerMethod;

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
