package com.junpenghe.reflection.polymorphism;

public class DatabaseClient {
    public boolean storeData(String data) {
        System.out.println(String.format("Data : %s was successfully stored in database", data));
        return true;
    }
}
