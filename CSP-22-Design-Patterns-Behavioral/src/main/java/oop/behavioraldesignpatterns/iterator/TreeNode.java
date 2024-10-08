package oop.behavioraldesignpatterns.iterator;

public class TreeNode<T> {
    TreeNode leftNode;
    TreeNode rightNode;
    T value;

    public TreeNode(T value) {
        this.value = value;
    }
}
