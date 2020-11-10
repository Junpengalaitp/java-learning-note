package com.junpenghe.design.pattern.creational.abstractfactory;

/**
 * @author Junpeng He
 */
public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
