package oop.behavioraldesignpatterns.homeworkCache.commands;

import java.util.Stack;

public class CommandManager<K,V> {
    private Stack<CacheCommand<K,V>> undoStack = new Stack<>();
    private Stack<CacheCommand<K,V>> redoStack = new Stack<>();

    public void executeCommand(CacheCommand<K,V> command) {
        command.execute();
        undoStack.push(command);
        // Redo allows you to re-execute commands that were previously undone.
        // The redoStack holds the history of undone commands.
        // When you perform an undo, the undone command gets pushed onto the redoStack, allowing you to redo it later if needed.
        // However, when you execute a new command after undoing something,
        // the previous "undo history" becomes invalid for redo purposes.
        // So  it's important to clear the redo history each time when a new command is executed
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            CacheCommand<K,V> commandToUndo = undoStack.pop();
            commandToUndo.undo();
            redoStack.push(commandToUndo);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            CacheCommand<K,V> commandToRedo = redoStack.pop();
            commandToRedo.execute();
            undoStack.push(commandToRedo);
        }
    }
}
