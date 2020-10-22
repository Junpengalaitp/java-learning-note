package com.junpenghe.java.basic.object.inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Inheritance
 *
 * Inheritance expresses this similarity through the concept of base types and derived types.
 * A base type contains all characteristics and behaviors shared among the types derived from it.
 * You create a base type to represent the core of your ideas. From the base type, you derive other
 * types to express the different ways this core can be realized.
 *
 * 这种通过继承的类型等价性是理解面向对象编程含义的基本门槛之一。因为基类和派生类都具有相同的基本接口，所以伴随此接口的必定有某些具体实现。
 * 也就是说，当对象接收到特定消息时，必须有可执行代码。如果继承一个类而不做其他任何事，则来自基类接口的方法直接进入派生类。
 * 这意味着派生类和基类不仅具有相同的类型，而且具有相同的行为，这么做没什么特别意义。
 *
 * 有两种方法可以区分新的派生类与原始的基类。第一种方法很简单：在派生类中添加新方法。这些新方法不是基类接口的一部分。
 * 这意味着基类不能满足你的所有需求，所以你添加了更多的方法。继承的这种简单而原始的用途有时是解决问题的完美解决方案。
 * 然而，还是要仔细考虑是否在基类中也要有这些额外的方法。这种设计的发现与迭代过程在面向对象程序设计中会经常发生。
 *
 * 尽管继承有时意味着你要在接口中添加新方法（尤其是在以 extends 关键字表示继承的 Java 中），但并非总需如此。
 * 第二种也是更重要地区分派生类和基类的方法是改变现有基类方法的行为，这被称为覆盖 (overriding)。
 * 要想覆盖一个方法，只需要在派生类中重新定义这个方法即可。
 *
 * 自从 C++ 引入以来，一个 OOP 问题变得尤为突出：是否所有的类都应该默认从一个基类继承呢？这个答案在 Java 中是肯定的
 * （实际上，除 C++ 以外的几乎所有OOP语言中也是这样）。在 Java 中，这个最终基类的名字就是 Object。
 *
 * Java 的单继承结构有很多好处。由于所有对象都具有一个公共接口，因此它们最终都属于同一个基类。
 * 相反的，对于 C++ 所使用的多继承的方案则是不保证所有的对象都属于同一个基类。从向后兼容的角度看，多继承的方案更符合 C 的模型，而且受限较少。
 *
 * 对于完全面向对象编程，我们必须要构建自己的层次结构，以提供与其他 OOP 语言同样的便利。我们经常会使用到新的类库和不兼容的接口。
 * 为了整合它们而花费大气力（有可能还要用上多继承）以获得 C++ 样的“灵活性”值得吗？如果从零开始，Java 这样的替代方案会是更好的选择。
 *
 * 另外，单继承的结构使得垃圾收集器的实现更为容易。这也是 Java 在 C++ 基础上的根本改进之一。
 */
public class InheritanceMain {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Shape shape = new Shape();
        shapes.add(shape);
        Square square = new Square();
        shapes.add(square);
        Circle circle = new Circle();
        shapes.add(circle);
        Triangle triangle = new Triangle();
        shapes.add(triangle);

        /*
         * use parent class, method call still uses child class
         */
        for (Shape s : shapes) {
            s.draw();
            s.erase();
            s.move();
            /*
            /* only Circle class overrides parent getColor(), so it will get color in itself, not parent's
             */
            System.out.println(s.getColor());
            if (s instanceof Triangle) {
                ((Triangle) s).flipHorizontal();
                ((Triangle) s).flipVertical();
            }
        }
    }
}
