package com.junpenghe.java.basic.polymophism.basic;

/**
 * Method-Call Binding
 * Connecting a method call to a method body is called binding.
 * early binding: binding is performed before the program runs(by the compiler and linker, if there is one).
 * late binding: binding occurs at run time, based on the type of object.
 * <p>
 * All method binding in Java uses late binding unless the method is static or final (private methods are implicitly final).
 * This means that ordinarily you don’t make decisions about whether late binding will occur—it happens automatically
 * <p>
 * 方法调用绑定
 * 将一个方法调用和一个方法主体关联起来称作绑定。若绑定发生在程序运行前（如果有的话，由编译器和链接器实现），
 * 叫做前期绑定。你可能从来没有听说这个术语，因为它是面向过程语言不需选择默认的绑定方式，例如在 C 语言中就只有前期绑定这一种方法调用。
 * <p>
 * 上述程序让人困惑的地方就在于前期绑定，因为编译器只知道一个 Instrument 引用，它无法得知究竟会调用哪个方法。
 * <p>
 * 解决方法就是后期绑定，意味着在运行时根据对象的类型进行绑定。后期绑定也称为动态绑定或运行时绑定。
 * 当一种语言实现了后期绑定，就必须具有某种机制在运行时能判断对象的类型，从而调用恰当的方法。
 * 也就是说，编译器仍然不知道对象的类型，但是方法调用机制能找到正确的方法体并调用。
 * 每种语言的后期绑定机制都不同，但是可以想到，对象中一定存在某种类型信息。
 * <p>
 * Java 中除了 static 和 final 方法（private 方法也是隐式的 final）外，其他所有方法都是后期绑定。
 * 这意味着通常情况下，我们不需要判断后期绑定是否会发生——它自动发生。
 * <p>
 * 为什么将一个对象指明为 final ？正如前一章所述，它可以防止方法被重写。
 * 但更重要的一点可能是，它有效地”关闭了“动态绑定，或者说告诉编译器不需要对其进行动态绑定。
 * 这可以让编译器为 final 方法生成更高效的代码。
 * 然而，大部分情况下这样做不会对程序的整体性能带来什么改变，因此最好是为了设计使用 final，而不是为了提升性能而使用。
 */
public class Binding {
}
