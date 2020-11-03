package com.junpenghe.java.basic.functional.interfaces;

import java.util.concurrent.Callable;
import java.util.function.*;

/**
 * @author Junpeng He
 */
public class FunctionalInterface {
    // no arg, no return
    Runnable runnable;

    // no arg, return any type
    Supplier<?> supplier;
    IntSupplier intSupplier;
    LongSupplier longSupplier;
    DoubleSupplier doubleSupplier;
    BooleanSupplier booleanSupplier;
    Callable<?> callable;

    // one arg, return nothing
    Consumer<?> consumer;
    IntConsumer intConsumer;
    LongConsumer longConsumer;
    DoubleConsumer doubleConsumer;

    // two args, no return;
    BiConsumer<?, ?> biConsumer;

    // one arg, return different type
    Function<?, ?> function;
    IntFunction<?> intFunction;

    // return bool
    Predicate<?> predicate;
    BiPredicate<?, ?> biPredicate;
}
