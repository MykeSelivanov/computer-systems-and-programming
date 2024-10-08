package oop.behavioraldesignpatterns.iterator;

import java.util.ArrayList;
import java.util.Stack;

public class TreeNodeIterator<T> implements Iterator<T> {
    private final TreeNode<T> root;
    private Stack<TreeNode<T>> stack;

    public TreeNodeIterator(TreeNode<T> root) {
        this.root = root;
        this.stack = new Stack<>();
        stack.push(root);
    }

    @Override
    public boolean hsaNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {

        TreeNode<T> node = stack.pop();
        if (node.rightNode != null) {
            stack.push(node.rightNode);
        }
        if (node.leftNode != null) {
            stack.push(node.leftNode);
        }
        return node.value;
    }
}
