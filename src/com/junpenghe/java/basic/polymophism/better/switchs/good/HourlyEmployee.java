package com.junpenghe.java.basic.polymophism.better.switchs.good;

import com.junpenghe.java.basic.polymophism.better.switchs.Money;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(EmployeeRecord employeeRecord) {
        super();
    }

    @Override
    public boolean isPayday() {
        return false;
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public void deliverPay(Money pay) {

    }
}
