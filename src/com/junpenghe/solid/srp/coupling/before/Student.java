package com.junpenghe.solid.srp.coupling.before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

public class Student {
    private String studentId;
    private Date studentDOB;
    private String address;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
