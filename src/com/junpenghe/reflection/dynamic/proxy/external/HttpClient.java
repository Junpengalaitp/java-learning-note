package com.junpenghe.reflection.dynamic.proxy.external;

/**
 * @author Junpeng He
 */
public interface HttpClient {

    void initialize();

    String sendRequest(String request);
}
