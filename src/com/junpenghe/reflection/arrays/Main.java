package com.junpenghe.reflection.arrays;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] oneDArray = {1, 2};
        double[][] twoDArray = {{1.0, 2.0}, {3.0, 4.0}};
        int[][][] threeDArray = {{{1}, {2}}, {{3}, {4}}};
        inspectArrayValues(threeDArray);
    }

    public static void inspectArrayValues(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayObject, i);

            if (element.getClass().isArray()) {
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }

            if (i != arrayLength - 1) {
                System.out.print(" , ");
            }
        }
        System.out.print("]");
    }

    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("Is array : %s", clazz.isArray()));
        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This is an array of type : %s", arrayComponentType.getTypeName()));
    }
}
