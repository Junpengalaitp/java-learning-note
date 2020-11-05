package com.junpenghe.design.pattern.behavioral.strategy.payment;

/**
 * @author Junpeng He
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
