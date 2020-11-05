package com.junpenghe.design.pattern.behavioral.chain.of.responsibility.middleware;

/**
 * @author Junpeng He
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
