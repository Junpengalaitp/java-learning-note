package com.junpenghe.java.basic.polymophism.better.switchs.good;

import com.junpenghe.java.basic.polymophism.better.switchs.InvalidEmployeeType;

public interface EmployeeFactory {
    Employee makeEmployee(EmployeeRecord employeeRecord) throws InvalidEmployeeType;
}
