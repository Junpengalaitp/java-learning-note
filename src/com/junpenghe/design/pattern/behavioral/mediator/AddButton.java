package com.junpenghe.design.pattern.behavioral.mediator;

import com.junpenghe.design.pattern.behavioral.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Junpeng He
 */
public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}
