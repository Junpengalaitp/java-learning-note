package com.junpenghe.reflection.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Junpeng He
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Address address = createInstanceWithArguments(Address.class, "First Street", 10);
        Person person = createInstanceWithArguments(Person.class, address, "John", 10);
        System.out.println(person);
    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (checkConstructor(constructor.getParameterTypes(), args)) {
                return (T) constructor.newInstance(args);
            }
        }
        throw new RuntimeException("no appropriate constructor was found");
    }

    private static boolean checkConstructor(Class<?>[] classes, Object... args) {
        if (classes.length != args.length) {
            return false;
        }
//        List<Class<?>> argClasses = new ArrayList<>();
//        for (Object arg : args) {
//            argClasses.add(arg.getClass());
//        }
//        if (!Arrays.equals(classes, argClasses.toArray())) {
//            return false;
//        }
        return true;
    }

    public static void printConstructors(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));
        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            List<String> parameterTypeNames = Arrays.stream(parameterTypes).map(type -> type.getSimpleName()).collect(Collectors.toList());
            System.out.println(parameterTypeNames);
        }
    }

    public static class Person {
        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }
        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
