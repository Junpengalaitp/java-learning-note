package com.junpenghe.java.basic.polymophism.better.switchs.good;

import com.junpenghe.java.basic.polymophism.better.switchs.Money;

public abstract class Employee {
    public abstract boolean isPayday();

    public abstract Money calculatePay();

    public abstract void deliverPay(Money pay);
}
