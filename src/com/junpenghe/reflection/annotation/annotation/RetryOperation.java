package com.junpenghe.reflection.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Junpeng He
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RetryOperation {
    Class<? extends Throwable>[] retryExceptions() default {Exception.class};

    long durationBetweenRetriesMs() default 0;

    String failureMessage() default "Operation failed after retrying";

    int numberOfRetries();
}
