package com.junpenghe.java.basic.polymophism.better.switchs.bad;

import com.junpenghe.java.basic.polymophism.better.switchs.InvalidEmployeeType;
import com.junpenghe.java.basic.polymophism.better.switchs.Money;

public class BadSwitch {

    public Money calculatePay(Employee employee) throws InvalidEmployeeType {
        switch (employee.type) {
            case "COMMISSIONED":
                return calculationsCommissionedPay(employee);
            case "HOURLY":
                return calculateHourlyPay(employee);
            case "SALARIED":
                return calculateSalariedPay(employee);
            default:
                throw new InvalidEmployeeType(employee.type);
        }
    }

    private Money calculateSalariedPay(Employee employee) {
        return null;
    }

    private Money calculateHourlyPay(Employee employee) {
        return null;
    }

    private Money calculationsCommissionedPay(Employee employee) {
        return null;
    }
}
