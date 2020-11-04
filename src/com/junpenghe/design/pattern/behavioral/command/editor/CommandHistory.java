package com.junpenghe.design.pattern.behavioral.command.editor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Junpeng He
 */
public class CommandHistory {
    private Deque<Command> history = new ArrayDeque<>();

    public void push(Command c) {
        history.addLast(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
