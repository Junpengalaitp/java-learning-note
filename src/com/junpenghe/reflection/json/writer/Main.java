package com.junpenghe.reflection.json.writer;

import com.junpenghe.reflection.json.data.Address;

import java.lang.reflect.Field;

/**
 * @author Junpeng He
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("Main Street", (short) 1);
        String json = objectToJson(address);
        System.out.println(json);
    }

    public static String objectToJson(Object instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (field.isSynthetic()) {
                continue;
            }
            stringBuilder.append(formatStringValue(field.getName()));
            stringBuilder.append(":");

            if (field.getType().isPrimitive()) {
                stringBuilder.append(formatPrimitiveValue(field, instance));
            } else if (field.getType().equals(String.class)) {
                stringBuilder.append(formatStringValue(field.get(instance).toString()));
            }
            if (i != fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static String formatPrimitiveValue(Field field, Object parentInstance) throws IllegalAccessException {
        if (field.getType().equals(boolean.class)
                || field.getType().equals(int.class)
                || field.getType().equals(long.class)
                || field.getType().equals(short.class)) {
            return field.get(parentInstance).toString();
        } else if (field.getType().equals(double.class) || field.getType().equals(float.class)) {
            return String.format("%.02f", field.get(parentInstance));
        }
        throw new RuntimeException("Type: " + field.getType().getName() + " is not supported");
    }

    private static String formatStringValue(String value) {
        return String.format("\"%s\"", value);
    }
}
