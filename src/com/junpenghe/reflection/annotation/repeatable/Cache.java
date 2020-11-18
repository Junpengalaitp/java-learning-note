package com.junpenghe.reflection.annotation.repeatable;

import com.junpenghe.reflection.annotation.annotation.ExecuteOnSchedule;
import com.junpenghe.reflection.annotation.annotation.ScheduledExecutorClass;

/**
 * @author Junpeng He
 */
@ScheduledExecutorClass
public class Cache {

    @ExecuteOnSchedule(periodSeconds = 5)
    @ExecuteOnSchedule(periodSeconds = 1, delaySeconds = 10)
    public static void reloadCache() {
        System.out.println("Reloading cache");
    }
}
