package com.junpenghe.java.basic.polymophism.consturctor;

/**
 * constructors are different from other kinds of methods. This is also true when polymorphism is involved.
 * Even though constructors are not polymorphic (they’re actually static methods, but the static declaration is implicit),
 * it’s important to understand the way constructors work in complex hierarchies and with polymorphism.
 * This understanding will help you avoid unpleasant entanglements.
 * <p>
 * A constructor for the base class is always called during the construction process for a derived class.
 * The initialization automatically moves up the inheritance hierarchy so a constructor for every base class is called.
 * <p>
 * This makes sense because the constructor has a special job: to see that the object is built properly.
 * Since fields are usually private, you must generally assume that a derived class has access to its own members only,
 * and not to those of the base class. Only the base-class constructor has the proper knowledge and access
 * o initialize its own elements. Therefore, it’s essential that all constructors get called; otherwise,
 * the entire object wouldn't be constructed. That’s why the compiler enforces a constructor call for
 * every portion of a derived class. It will silently call the no-arg constructor if you don’t explicitly
 * call a base-class constructor in the derived-class constructor body. If there is no no-arg constructor,
 * the compiler will complain. (In the case where a class has no constructors, the compiler will
 * automatically synthesize a no-arg constructor.)
 */
public class Constructor {
    public static void main(String[] args) {
        new Sandwich();
    }
}
