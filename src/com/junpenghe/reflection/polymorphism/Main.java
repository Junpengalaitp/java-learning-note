package com.junpenghe.reflection.polymorphism;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DatabaseClient databaseClient = new DatabaseClient();
        HttpClient httpClient1 = new HttpClient("123.456.789.0");
        HttpClient httpClient2 = new HttpClient("123.456.789.1");
        FileLogger fileLogger = new FileLogger();
        UdpClient updClient = new UdpClient();

        String requestBody = "request data";
        List<Class<?>> methodParameterTypes = Arrays.asList(new Class<?>[]{String.class});

        Map<Object, Method> requestExecutors = groupExecutors(Arrays.asList(databaseClient, httpClient1, httpClient2, fileLogger, updClient), methodParameterTypes);

        executeAll(requestExecutors, requestBody);
    }

    public static void executeAll(Map<Object, Method> requestExecutors, String requestBody) throws InvocationTargetException, IllegalAccessException {
        for (Map.Entry<Object, Method> requestExecutorEntry : requestExecutors.entrySet()) {
            Object requestExecutor = requestExecutorEntry.getKey();
            Method method = requestExecutorEntry.getValue();

            method.invoke(requestExecutor, requestBody);

            Boolean result = (Boolean) method.invoke(requestExecutor, requestBody);

            if (Boolean.FALSE.equals(result)) {
                System.out.println("Received negative result. Aborting...");
                return;
            }
        }
    }

    public static Map<Object, Method> groupExecutors(List<Object> requestExecutors, List<Class<?>> methodParameterTypes) {
        Map<Object, Method> instanceToMethod = new HashMap<>();
        for (Object requestExecutor : requestExecutors) {
            Method[] allMethods = requestExecutor.getClass().getDeclaredMethods();

            for (Method method : allMethods) {
                if (Arrays.asList(method.getParameterTypes()).equals(methodParameterTypes)) {
                    instanceToMethod.put(requestExecutor, method);
                }
            }
        }
        return instanceToMethod;
    }
}
