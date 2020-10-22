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
     * An Object Has an Interface
     *
     * Each object accepts only certain requests, defined by
     * its interface The type determines the interface
     *
     * 对象有对外的接口
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

    /**
     * Objects Provide Services
     *
     * Your program itself will provide services to the user, and it will accomplish this
     * by using the service offered by other objects.
     *
     * Treating objects as service providers is useful not only during the design process,
     * but also when someone else is trying to understand your code or reuse an object.
     * If they can see the value of the object based on what service it provides,
     * it makes it much easier to fit it into the design.
     *
     * High cohesion is a fundamental quality of software design: It means the various
     * aspects of a software component (such as an object, although this could also apply
     * to a method or a library of objects) “fit together” well.
     *
     * 在开发或理解程序设计时，我们可以将对象看成是“服务提供者”。你的程序本身将为用户提供服务，
     * 并且它能通过调用其他对象提供的服务来实现这一点。我们的最终目标是开发或调用工具库中已有的一些对象，
     * 提供理想的服务来解决问题。
     *
     * 那么问题来了：我们该选择哪个对象来解决问题呢？例如，你正在开发一个记事本程序。你可能会想到在屏幕输入默认的记事本对象，
     * 一个用于检测不同类型打印机并执行打印的对象。这些对象中的某些已经有了。那对于还没有的对象，我们该设计成啥样呢？这些对象需要提供哪些服务，
     * 以及还需要调用其他哪些对象？
     *
     * 我们可以将这些问题一一分解，抽象成一组服务。软件设计的基本原则是高内聚：每个组件的内部作用明确，功能紧密相关。
     * 然而经常有人将太多功能塞进一个对象中。例如：在支票打印模块中，你需要设计一个可以同时读取文本格式又能正确识别不同打印机型号的对象。
     * 正确的做法是提供三个或更多对象：一个对象检查所有排版布局的目录；一个或一组可以识别不同打印机型号的对象展示通用的打印界面；
     * 第三个对象组合上述两个服务来完成任务。这样，每个对象都提供了一组紧密的服务。在良好的面向对象设计中，每个对象功能单一且高效。
     * 这样的程序设计可以提高我们代码的复用性，同时也方便别人阅读和理解我们的代码。只有让人知道你提供什么服务，别人才能更好地将其应用到其他模块或程序中。
     */

    /**
     * The Hidden Implementation
     *
     * The class creator can change the hidden portion at will without worrying about the impact on anyone else.
     * Hiding the implementation reduces program bugs.
     *
     * 封装
     * 我们可以把编程的侧重领域划分为研发和应用。应用程序员调用研发程序员构建的基础工具类来做快速开发。研发程序员开发一个工具类，
     * 该工具类仅向应用程序员公开必要的内容，并隐藏内部实现的细节。这样可以有效地避免该工具类被错误的使用和更改，从而减少程序出错的可能。
     * 彼此职责划分清晰，相互协作。当应用程序员调用研发程序员开发的工具类时，双方建立了关系。
     * 应用程序员通过使用现成的工具类组装应用程序或者构建更大的工具库。如果工具类的创建者将类的内部所有信息都公开给调用者，
     * 那么有些使用规则就不容易被遵守。因为前者无法保证后者是否会按照正确的规则来使用，甚至是改变该工具类。只有设定访问控制，
     * 才能从根本上阻止这种情况的发生。
     *
     * 因此，使用访问控制的原因有以下两点：
     *
     * 让应用程序员不要触摸他们不应该触摸的部分。（请注意，这也是一个哲学决策。部分编程语言认为如果程序员有需要，则应该让他们访问细节部分。）；
     *
     * 使类库的创建者（研发程序员）在不影响后者使用的情况下完善更新工具库。例如，我们开发了一个功能简单的工具类，
     * 后来发现可以通过优化代码来提高执行速度。
     * 假如工具类的接口和实现部分明确分开并受到保护，那我们就可以轻松地完成改造。
     */

    /**
     * Reusing the Implementation
     *
     * Code reuse is an argument for object-oriented programming languages.
     * The simplest way to reuse a class is to use an object of that class directly,
     * but you can also place an object of that class inside a new class.
     * Your new class can be made up of any number and type of other objects, in any combination,
     * to produce the desired functionality.
     *
     * 一个类经创建和测试后，理应是可复用的。然而很多时候，由于程序员没有足够的编程经验和远见，我们的代码复用性并不强。
     *
     * 代码和设计方案的复用性是面向对象程序设计的优点之一。我们可以通过重复使用某个类的对象来达到这种复用性。
     * 同时，我们也可以将一个类的对象作为另一个类的成员变量使用。新的类可以是由任意数量和任意类型的其他对象构成。
     * 这里涉及到“组合”和“聚合”的概念：
     *
     * 组合（Composition）经常用来表示“拥有”关系（has-a relationship）。例如，“汽车拥有引擎”。
     *
     * 聚合（Aggregation）动态的组合。
     */

}
