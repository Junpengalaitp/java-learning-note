package com.junpenghe.design.pattern.creational.factory.buttons;

/**
 * @author Junpeng He
 */
public class Demo {
    private static Dialog dialog;

    static void configure() {
        if ("Windows 10".equals(System.getProperty("os.name"))) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }
}
