package com.junpenghe.reflection.dynamic.proxy.external.impl;

import com.junpenghe.reflection.dynamic.proxy.external.HttpClient;

/**
 * @author Junpeng He
 */
public class HttpClientImpl implements HttpClient {
    @Override
    public void initialize() {
        System.out.println("Initializing HTTP client");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sendRequest(String request) {
        System.out.println(String.format("Sending request %s", request));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received response");
        return "some response data";
    }
}
