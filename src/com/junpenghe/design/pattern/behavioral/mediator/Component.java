package com.junpenghe.design.pattern.behavioral.mediator;

/**
 * @author Junpeng He
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
