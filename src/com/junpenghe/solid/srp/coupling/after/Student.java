package com.junpenghe.solid.srp.coupling.after;

import java.util.Date;

public class Student {
    private String studentId;
    private Date studentDOB;
    private String address;

    public void save() {
        new StudentRepository().save();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
