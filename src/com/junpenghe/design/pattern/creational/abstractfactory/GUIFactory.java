package com.junpenghe.design.pattern.creational.abstractfactory;

/**
 * @author Junpeng He
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
