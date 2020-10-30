package com.junpenghe.java.basic.functional.programming;

/**
 * @author Junpeng He
 *
 * Often, just to fit a program into limited memory, programmers saved code space by modifying in-memory
 * code to make it do something different, while the program was executing. This technique is called
 * self-modifying code, and as long as a program was small enough for a handful of people to maintain
 * all the tricky and arcane assembly code, you could probably get it to work
 *
 * From a code creation, maintenance, and reliability standpoint this idea is quite compelling.
 * If, instead of writing lots of code from scratch, you start with existing small pieces that
 * are understandable, well-tested, and reliable. Then compose them together to create new code.
 * Wouldn’t that make us more productive and at the same time create more robust code? This is
 * what functional programming (FP) is about. By incorporating existing code to produce new
 * functionality instead of writing everything from scratch, you get more reliable code, faster.
 * This theory seems to hold up, at least in some situations. On the way, functional languages
 * have produced nice syntax which some non-functional languages have appropriated. You can also
 * think of it this way: OO abstracts data, FP abstracts behavior. A pure functional language
 * goes further in its endeavor for safety. It imposes the additional constraint that all data
 * must be immutable: set once and never changed. Values are handed to a function which then
 * produces new values but never modifies anything external to itself(including its arguments or
 * elements outside of that function’s scope). When this is enforced, you know that any bugs are
 * not caused by so- called side effects, because the function only creates and returns a result,
 * nothing else. Even better, the “immutable objects and no side effects” paradigm solves one of
 * the most fundamental and vexing problems in parallel programming (when parts of your program
 * are running simultaneously on multiple processors). This is the problem of mutable shared state,
 * which means different parts of your code (running on different processors) can try to modify
 * the same piece of memory at the same time (Who wins? Nobody knows). If functions never modify
 * existing values but only produce new values—the definition of a pure functional language—there
 * can be no contention over memory. Thus, pure functional languages are often put forward as the
 * solution to parallel programming (there are also other viable solutions). Be aware, then, that
 * there are numerous motivations behind functional languages, which means describing them can be
 * somewhat confusing. It often depends on perspective. The reasons span “it’s for parallel
 * programming,” to “code reliability” and “code creation and library reuse.” 1 Also remember that
 * the arguments for FP—in particular, that programmers will create more robust code, faster—are
 * still at least partly hypothetical. We have seen some good results,2 but we haven’t proven that
 * a pure functional language is the best approach to solving the programming problem.
 *
 * 通过合并现有代码来生成新功能而不是从头开始编写所有内容，我们可以更快地获得更可靠的代码。至少在某些情况下，这套理论似乎很有用。
 * 在这一过程中，函数式语言已经产生了优雅的语法，这些语法对于非函数式语言也适用。
 *
 * 你也可以这样想：
 *
 * OO（object oriented，面向对象）是抽象数据，FP（functional programming，函数式编程）是抽象行为。
 *
 * 纯粹的函数式语言在安全性方面更进一步。它强加了额外的约束，即所有数据必须是不可变的：设置一次，永不改变。将值传递给函数，
 * 该函数然后生成新值但从不修改自身外部的任何东西（包括其参数或该函数范围之外的元素）。当强制执行此操作时，
 * 你知道任何错误都不是由所谓的副作用引起的，因为该函数仅创建并返回结果，而不是其他任何错误。
 *
 * 更好的是，“不可变对象和无副作用”范式解决了并发编程中最基本和最棘手的问题之一（当程序的某些部分同时在多个处理器上运行时）。
 * 这是可变共享状态的问题，这意味着代码的不同部分（在不同的处理器上运行）可以尝试同时修改同一块内存（谁赢了？没人知道）。
 * 如果函数永远不会修改现有值但只生成新值，则不会对内存产生争用，这是纯函数式语言的定义。
 * 因此，经常提出纯函数式语言作为并行编程的解决方案（还有其他可行的解决方案）。
 *
 * 需要提醒大家的是，函数式语言背后有很多动机，这意味着描述它们可能会有些混淆。它通常取决于各种观点：为“并行编程”，“代码可靠性”和“代码创建和库复用”
 * 。^1 关于函数式编程能高效创建更健壮的代码这一观点仍存在部分争议。虽然已有一些好的范例[^2]，但还不足以证明纯函数式语言就是解决编程问题的最佳方法。
 */
public class Main {
}
