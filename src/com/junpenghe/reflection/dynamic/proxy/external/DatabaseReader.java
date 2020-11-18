package com.junpenghe.reflection.dynamic.proxy.external;

/**
 * @author Junpeng He
 */
public interface DatabaseReader {
    int countRowsInTable(String tableName) throws InterruptedException;

    String[] readRow(String sqlQuery) throws InterruptedException;
}
