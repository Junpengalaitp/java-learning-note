package com.junpenghe.design.pattern.creational.abstractfactory;

/**
 * @author Junpeng He
 */
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
