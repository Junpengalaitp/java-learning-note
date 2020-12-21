package com.junpenghe.java.basic.housekeeping.overloading.constructor;

/**
 * Because the constructor’s name is predetermined by the name of the class, there can be only one constructor name.
 * But how do you create an object in more than one way? For example, suppose you build a class that can initialize
 * itself in a standard way or by reading information from a file. You need two constructors, the no-arg constructor
 * and one that takes a String as an argument, which is the name of the file from which to initialize the object.
 * Both are constructors, so they must have the same name—the name of the class. Thus, method overloading is necessary
 * to allow the same method name with different argument types. And although method overloading is essential for
 * constructors, it’s a general convenience and can be used with any method.
 * <p>
 * 在 Java (C++) 中，还有一个因素也促使了必须使用方法重载：构造器。因为构造器方法名肯定是与类名相同，所以一个类中只会有一个构造器名。
 * 那么你怎么通过不同的方式创建一个对象呢？例如，你想创建一个类，这个类的初始化方式有两种：一种是标准化方式，另一种是从文件中读取信息的方式。
 * 你需要两个构造器：无参构造器和有一个 String 类型参数的构造器，该参数传入文件名。两个构造器具有相同的名字——与类名相同。
 * 因此，方法重载是必要的，它允许方法具有相同的方法名但接收的参数不同。尽管方法重载对于构造器是重要的，但是也可以很方便地对其他任何方法进行重载。
 */
public class Constructor {
    static class Tree {
        int height;

        Tree() {
            System.out.println("Planting a seedling");
            height = 0;
        }

        Tree(int initialHeight) {
            height = initialHeight;
            System.out.println("Creating new Tree that is " + height + " feet tall");
        }

        void info() {
            System.out.println("Tree is " + height + " feet tall");
        }

        void info(String s) {
            System.out.println(s + ": Tree is " + height + " feet tall");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        new Tree();
    }

}
