package com.junpenghe.reflection.access.restricted.constructor;

import com.junpenghe.reflection.access.restricted.constructor.web.WebServer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Junpeng He
 */
public class Main {

    public static void main(String[] args) throws Exception {
        initConfig();
        WebServer webServer = new WebServer();
        webServer.startServer();
    }

    public static void initConfig() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ServerConfiguration> constructor = ServerConfiguration.class.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        constructor.newInstance(8080, "GoodDay!");
    }
}
