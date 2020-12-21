package com.junpenghe.java.basic.interfaces.combining;

/**
 * @author Junpeng He
 */
public class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {
    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
