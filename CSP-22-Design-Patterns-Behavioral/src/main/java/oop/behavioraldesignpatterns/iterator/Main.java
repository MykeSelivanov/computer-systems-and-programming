package oop.behavioraldesignpatterns.iterator;

public class Main {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        root.leftNode = new TreeNode<>(2);
        root.rightNode = new TreeNode<>(5);
        root.leftNode.leftNode = new TreeNode<>(1);
        root.rightNode.rightNode = new TreeNode<>(3);

        // Traverse the tree using TreeNodeIterator
        Iterator<Integer> treeNodeIterator = new TreeNodeIterator<>(root);
        while (treeNodeIterator.hsaNext()) {
            System.out.println(treeNodeIterator.next() + " ");
        }
    }
}
