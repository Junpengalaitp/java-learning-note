package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.annotation.InitializerMethod;

/**
 * @author Junpeng He
 */
@InitializerClass
public class CacheLoader {
    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
