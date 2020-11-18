package com.junpenghe.reflection.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author Junpeng He
 */
@Repeatable(ExecutionSchedules.class)
@Target(ElementType.METHOD)
public @interface ExecuteOnSchedule {
    int delaySeconds() default 0;
    int periodSeconds();
}
