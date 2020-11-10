package com.junpenghe.design.pattern.creational.abstractfactory;

/**
 * @author Junpeng He
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
