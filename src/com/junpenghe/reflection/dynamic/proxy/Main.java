package com.junpenghe.reflection.dynamic.proxy;

import com.junpenghe.reflection.dynamic.proxy.external.DatabaseReader;
import com.junpenghe.reflection.dynamic.proxy.external.HttpClient;
import com.junpenghe.reflection.dynamic.proxy.external.impl.DatabaseReaderImpl;
import com.junpenghe.reflection.dynamic.proxy.external.impl.HttpClientImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Junpeng He
 */
public class Main {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = createProxy(new HttpClientImpl());
        DatabaseReader databaseReader = createProxy(new DatabaseReaderImpl());
        useHttpClient(httpClient);
        useDataBaseReader(databaseReader);

        List<String> listOfGreetings = createProxy(new ArrayList<>());
        listOfGreetings.add("hello");
        listOfGreetings.add("good morning");
        listOfGreetings.add("hello");
    }

    public static void useHttpClient(HttpClient httpClient) {
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");
        System.out.println(String.format("Http response is: %s", response));
    }

    public static void useDataBaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGamesTable = databaseReader.countRowsInTable("GamesTable");
        System.out.println(String.format("There are %s rows in GamesTable", rowsInGamesTable));
        String[] data = databaseReader.readRow("SELECT * from GamesTable");
        System.out.println(String.format("Received %s", String.join(" , ", data)));
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();
        TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);
        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }

    public static class TimeMeasuringProxyHandler implements InvocationHandler {
        private final Object originalObject;

        public TimeMeasuringProxyHandler(Object originalObject) {
            this.originalObject = originalObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;
            System.out.println(String.format("Measuring Proxy - Before Executing method: %s()", method.getName()));
            long startTime = System.nanoTime();
            result = method.invoke(originalObject, args);
            long endTime = System.nanoTime();
            System.out.println(String.format("Measuring Proxy - Execution of %s() took %dms \n", method.getName(), endTime - startTime));
            return result;
        }
    }
}
