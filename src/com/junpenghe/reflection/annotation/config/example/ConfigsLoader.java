package com.junpenghe.reflection.annotation.config.example;

import com.junpenghe.reflection.annotation.config.example.annotation.InitializerClass;
import com.junpenghe.reflection.annotation.config.example.annotation.InitializerMethod;

/**
 * @author Junpeng He
 */
@InitializerClass
public class ConfigsLoader {
    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }
}
