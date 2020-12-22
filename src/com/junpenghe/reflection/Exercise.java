package com.junpenghe.reflection;


import java.lang.reflect.Array;

/**
 * @author Junpeng He
 */
public class Exercise {

    public Object getArrayElement(Object array, int index) {
        if (index >= 0) {
            return Array.get(array, index);
        }
        int arrayLength = Array.getLength(array);
        return Array.get(array, arrayLength + index);
    }

}
