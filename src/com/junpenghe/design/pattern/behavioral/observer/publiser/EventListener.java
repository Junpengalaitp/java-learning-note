package com.junpenghe.design.pattern.behavioral.observer.publiser;

import java.io.File;

/**
 * @author Junpeng He
 */
public interface EventListener {
    void update(String eventType, File file);
}
