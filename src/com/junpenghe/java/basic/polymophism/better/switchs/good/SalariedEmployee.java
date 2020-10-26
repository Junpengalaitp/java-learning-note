package com.junpenghe.java.basic.polymophism.better.switchs.good;

import com.junpenghe.java.basic.polymophism.better.switchs.Money;

public class SalariedEmployee extends Employee {
    public SalariedEmployee(EmployeeRecord employeeRecord) {
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
