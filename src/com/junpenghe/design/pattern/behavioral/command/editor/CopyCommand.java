package com.junpenghe.design.pattern.behavioral.command.editor;

/**
 * @author Junpeng He
 */
public class CopyCommand extends Command {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
