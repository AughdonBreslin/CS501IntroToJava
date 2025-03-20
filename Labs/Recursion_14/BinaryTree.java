package Recursion_14;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class BinaryTree<T extends Comparable<T>>  {

    static class TreeNode<T extends Comparable<T>> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }

        int compareTo(TreeNode<T> other) {
            return this.data.compareTo(other.data);
        }
    }

    private TreeNode<T> root;

    // Recursive Operations
    private void insert(TreeNode<T> node, T value) {
        if (value.compareTo(node.data) < 0) {
            if (node.left == null) {
                System.out.println(" Inserted " + value + " to left of Node " + node.data);
                node.left = new TreeNode<>(value);
            } else {
                insert(node.left, value);
            }
        } else if (value.compareTo(node.data) > 0) {
            if (node.right == null) {
                System.out.println(" Inserted " + value + " to right of Node " + node.data);
                node.right = new TreeNode<>(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void insert(T value) {
        if (root == null) {
            System.out.println(" Inserted " + value + " as root of previously empty tree.");
            root = new TreeNode<>(value);
        } else {
            insert(root, value);
        }
    }

    private boolean contains(TreeNode<T> root, T value) {
        // Base case: Empty tree
        if (root == null) {
            return false;
        }

        // Base case 2: Found the value
        if (root.data.equals(value)) {
            return true;
        }

        // Recursive search in appropriate subtree
        if (value.compareTo(root.data) < 0) {
            return contains(root.left, value);
        } else {
            return contains(root.right, value);
        }
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    // Recursive traversals
    private void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrder() {
        postOrder(root);
    }
}

class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int count = 0;
        for (int i : new int[]{5, 3, 7, 2, 4, 6, 8, 1, 9}) {
            tree.insert(i);
        }
        System.out.println("\nInorder");
        tree.inOrder();
        System.out.println("\nPreorder");
        tree.preOrder();
        System.out.println("\nPostorder");
        tree.postOrder();
        System.out.println("\n" + tree.contains(9));
        System.out.println(tree.contains(0));
    }
}
