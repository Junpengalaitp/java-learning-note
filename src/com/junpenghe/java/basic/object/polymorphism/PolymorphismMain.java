package com.junpenghe.java.basic.object.polymorphism;

import com.junpenghe.java.basic.object.inheritance.Shape;
import com.junpenghe.java.basic.object.inheritance.Triangle;

/**
 * When dealing with type hierarchies, you often treat an object not as the specific type it is,
 * but as its base type.
 * This way you can write code that doesn't depend on specific types. In the shape example,
 * methods manipulate generic shapes,unconcerned about whether they’re circles, squares, triangles,
 * or some shape that hasn't even been defined yet. All shapes can be drawn, erased, and moved,
 * so these methods send a message to a shape object without worrying how the object copes with the message.
 *
 * Such code is unaffected by the addition of new types, and adding new types is a common way to extend an
 * object-oriented program to handle new situations. For example, you can derive a new subtype of shape called
 * “pentagon” without modifying methods that deal only with generic shapes. This ability to easily extend a design by
 * deriving new subtypes is one of the essential ways to encapsulate change. This improves designs while reducing
 * the cost of software maintenance. There’s a problem when attempting to treat derived-type objects as their
 * generic base types (circles as shapes, bicycles as vehicles, cormorants as birds, etc.).
 * If a method tells a generic shape to draw itself, or a generic vehicle to steer, or a generic bird to move,
 * the compiler cannot know at compile time precisely what piece of code is executed. That’s the whole point—when
 * the message is sent, the programmer doesn’t want to know what piece of code is executed; the draw method can be
 * applied equally to a circle, a square, or a triangle, and the object will execute the proper code depending
 * on its specific type.
 */
public class PolymorphismMain {

    /**
     * What’s happening here is that a Circle is passed into a method that expects a Shape.
     * Since a Circle is a Shape it is treated as such by doSomething(). That is, any message
     * that doSomething() can send to a Shape, a Circle can accept. It is a completely safe and
     * logical thing to do. We call this process of treating a derived type as though it were its
     * base type upcasting. The name cast is used in the sense of casting into a mold and the up
     * comes from the way the inheritance diagram is typically arranged, with the base type at the
     * top and the derived classes fanning out downward. Thus, casting to a base type is moving up
     * the inheritance diagram: “upcasting.” An object-oriented program contains upcasting somewhere,
     * because that’s how you decouple yourself from knowing the exact type you’re working with.
     * Look at the code in doSomething(): shape.erase(); // ... shape.draw(); Notice it doesn't say
     * , “If you’re a Circle, do this, if you’re a Square, do that, etc.” If you write that kind of code,
     * which checks for all the possible types a Shape can actually be, it’s messy and you must change it every
     * time you add a new kind of Shape. Here, you just say, “You’re a shape, I know you can erase() and draw()
     * yourself, do it, and take care of the details correctly.” What’s impressive about the code in doSomething() is that,
     * somehow, the right thing happens. Calling draw() for Circle causes different code to be executed than
     * calling draw() for a Square or a Line, but when the draw() message is sent to an anonymous Shape,
     * the correct behavior occurs based on the actual type of the Shape. This is amazing because when
     * the Java compiler is compiling the code for doSomething(), it cannot know exactly what types it is dealing with.
     * Ordinarily, you’d expect it to end up calling the version of erase() and draw() for the base class Shape,
     * and not for the specific Circle, Square, or Line. And yet the right thing happens—that’s polymorphism.
     * The compiler and runtime system handle the details; all you must know is it happens, and more importantly,
     * how to design with it. When you send a message to an object, the object will do the right thing,
     * even when upcasting is involved.
     *
     * 我们可以看到程序并未这样表达：“如果你是一个 Circle ，就这样做；如果你是一个 Square，就那样做...”。若那样编写代码，
     * 就需检查 Shape 所有可能的类型，如圆、矩形等等。这显然是非常麻烦的，而且每次添加了一种新的 Shape 类型后，都要相应地进行修改。
     * 在这里，我们只需说：“你是一种几何形状，我知道你能删掉 erase() 和绘制 draw()，你自己去做吧，注意细节。”
     *
     * 尽管我们没作出任何特殊指示，程序的操作也是完全正确和恰当的。我们知道，为 Circle 调用draw()
     * 时执行的代码与为一个 Square 或 Line 调用 draw() 时执行的代码是不同的。但在将 draw()
     * 信息发给一个匿名 Shape 时，根据 Shape 句柄当时连接的实际类型，会相应地采取正确的操作。这非常神奇，
     * 因为当 Java 编译器为 doSomething() 编译代码时，它并不知道自己要操作的准确类型是什么。
     *
     * 尽管我们确实可以保证最终会为 Shape 调用 erase() 和 draw()，但并不能确定特定的 Circle，
     * Square 或者 Line 调用什么。最后，程序执行的操作却依然是正确的，这是怎么做到的呢？
     *
     * 发送消息给对象时，如果程序不知道接收的具体类型是什么，但最终执行是正确的，这就是对象的“多态性”（Polymorphism）。
     * 面向对象的程序设计语言是通过“动态绑定”的方式来实现对象的多态性的。编译器和运行时系统会负责对所有细节的控制；我们只需知道要做什么，
     * 以及如何利用多态性来更好地设计程序。
     */
    public static void doSomething(Shape shape) {
        shape.draw();
        shape.erase();
    }

    public static void main(String[] args) {
        Shape shape = new Shape();
        Triangle triangle = new Triangle();
        doSomething(shape);
        // upcasting child class
        doSomething(triangle);
    }
}
