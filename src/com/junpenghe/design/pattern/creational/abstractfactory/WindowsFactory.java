package com.junpenghe.design.pattern.creational.abstractfactory;

/**
 * @author Junpeng He
 */
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
