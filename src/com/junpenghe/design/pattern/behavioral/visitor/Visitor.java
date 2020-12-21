package com.junpenghe.design.pattern.behavioral.visitor;

/**
 * @author Junpeng He
 */
public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitorRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
