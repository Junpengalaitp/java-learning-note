package com.junpenghe.java.basic.type.info;

/**
 * @author Junpeng He
 */

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}


public class SweetShop {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        Class<Gum> cls = Gum.class;
        Gum gum = cls.newInstance();
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
