package com.junpenghe.design.pattern.creational.factory.buttons;

/**
 * @author Junpeng He
 */
public class HtmlDialog extends Dialog {
    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
