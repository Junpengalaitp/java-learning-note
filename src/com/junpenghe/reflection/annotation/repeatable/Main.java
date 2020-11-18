package com.junpenghe.reflection.annotation.repeatable;

import com.junpenghe.reflection.annotation.annotation.ScanPackages;

import java.util.List;

/**
 * @author Junpeng He
 */
@ScanPackages({"com.junpenghe.reflection.annotation.repeatable"})
public class Main {
    public static void main(String[] args) {

    }

    public static List<Class<?>> getAllClasses(String... packageNames) {
        return null;
    }

    public static List<Class<?>> getAllPackageClasses(String... packageNames) {
        return null;
    }
}
