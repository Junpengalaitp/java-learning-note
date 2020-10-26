package com.junpenghe.java.basic.polymophism.calling.inside.constructor;

/**
 * The actual process of initialization is:
 * 1. The storage allocated for the object is initialized to binary zero before anything else happens.
 * 2. The base-class constructors are called as described previously.Now the overridden draw() method is called
 * (yes, before the RoundGlyph constructor is called), which discovers a radius value of zero, due to Step 1.
 * 3. Member initializers are called in the order of declaration.
 * 4. The body of the derived-class constructor is called.There’s an upside to this:
 * Everything is at least initialized to zero (or whatever zero means for that particular data type)
 * and not just left as garbage. This includes object references embedded inside a class via
 * composition, which become null. So if you forget to initialize that reference,
 * you’ll get an exception at run time. Everything else gets zero,
 * usually a telltale value when you are looking at output.
 *
 * The only safe methods to call inside a constructor are those that are final in the base class.
 * (This also applies to private methods, which are automatically final.)
 * These cannot be overridden and thus cannot produce this kind of surprise.
 * You might not always follow this guideline, but it’s something to strive towards
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
