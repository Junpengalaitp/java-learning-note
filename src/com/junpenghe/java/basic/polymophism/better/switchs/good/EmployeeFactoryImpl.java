package com.junpenghe.java.basic.polymophism.better.switchs.good;

import com.junpenghe.java.basic.polymophism.better.switchs.InvalidEmployeeType;

public class EmployeeFactoryImpl implements EmployeeFactory {
    @Override
    public Employee makeEmployee(EmployeeRecord employeeRecord) throws InvalidEmployeeType {
        switch (employeeRecord.type) {
            case "COMMISSIONED":
                return new CommissionedEmployee(employeeRecord);
            case "HOURLY":
                return new HourlyEmployee(employeeRecord);
            case "SALARIED":
                return new SalariedEmployee(employeeRecord);
            default:
                throw new InvalidEmployeeType(employeeRecord.type);
        }
    }

}
