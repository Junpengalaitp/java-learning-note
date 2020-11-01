package com.junpenghe.solid.srp.coupling.after;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentRepository {

    public void save() {
        String objectStr = "";
        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("localhost:3306/MyDB", "root", "password");
            stmt.execute("INSERT INTO STUDENT VALUES (" + objectStr + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
