package com.junpenghe.design.pattern.behavioral.chain.of.responsibility.middleware;

/**
 * @author Junpeng He
 */
public class RoleCheckMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if ("admin@example.com".equals(email)) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
