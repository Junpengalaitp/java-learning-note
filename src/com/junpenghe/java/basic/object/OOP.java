package com.junpenghe.java.basic.object;

/**
 * 1. Everything is an object. Think of an object as a fancy variable;
 * it stores data, but you can “make requests”, asking it to perform
 * operations on itself. You can usually take any conceptual
 * component in the problem you’re trying to solve (dogs, buildings,
 * services, etc.) and represent it as an object in your program.
 *
 * 2. A program is a bunch of objects telling each other what
 * to do by sending messages. When you “send a message” to an
 * object, it’s a request to call a method that belongs to that object.
 *
 * 3. Each object has its own memory made up of other
 * objects. Put another way, you create a new kind of object by
 * packaging existing objects. This hides the complexity of a program
 * behind the simplicity of objects.
 *
 * 4. Every object has a type. Each object is an instance of a class,
 * where “class” is (approximately) synonymous with “type.” The
 * most important distinguishing characteristic of a class is “What
 * messages can you send to it?”
 *
 * 5. All objects of a particular type can receive the same
 * messages. This is a loaded statement, as you will see later.
 * Because an object of type “circle” is also an object of type “shape,”
 * a circle is guaranteed to accept shape messages. This means you
 * can write code that talks to shapes and automatically handles
 * anything that fits the description of a shape. This substitutability
 * is a foundation of OOP.
 *
 * 1. 万物皆对象。你可以将对象想象成一种特殊的变量。它存储数据，但可以在你对其“发出请求”时执行本身的操作。理论上讲，
 *    你总是可以从要解决的问题身上抽象出概念性的组件，然后在程序中将其表示为一个对象。
 *
 * 2. 程序是一组对象，通过消息传递来告知彼此该做什么。要请求调用一个对象的方法，你需要向该对象发送消息。
 *
 * 3. 每个对象都有自己的存储空间，可容纳其他对象。或者说，通过封装现有对象，可制作出新型对象。所以，尽管对象的概念非常简单，
 *    但在程序中却可达到任意高的复杂程度。
 *
 * 4. 每个对象都有一种类型。根据语法，每个对象都是某个“类”的一个“实例”。其中，“类”（Class）是“类型”（Type）的同义词。
 *    一个类最重要的特征就是“能将什么消息发给它？”。
 *
 * 5. 同一类所有对象都能接收相同的消息。这实际是别有含义的一种说法，大家不久便能理解。由于类型为“圆”（Circle）
 *    的一个对象也属于类型为“形状”（Shape）的一个对象，所以一个圆完全能接收发送给"形状”的消息。这意味着可让程序代码统一指挥“形状”，
 *    令其自动控制所有符合“形状”描述的对象，其中自然包括“圆”。这一特性称为对象的“可替换性”，是OOP最重要的概念之一。
 */
public class OOP {

    /**
     * Interface
     * Each object accepts only certain requests, defined by
     * its interface The type determines the interface
     *
     * 我们向对象发出的请求是通过它的“接口”（Interface）定义的，对象的“类型”或“类”则规定了它的接口形式。
     * “类型”与“接口”的对应关系是面向对象程序设计的基础。
     */
    class Light {
        void on() {}
        void off() {}
        void brighten() {}
        void dim() {}
    }
}
