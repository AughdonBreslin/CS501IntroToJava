package Trees_17;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/12/2025, Saturday
 **/
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E value) {
        root = insertRec(root, value);
    }

    private Node<E> insertRec(Node<E> root, E value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (value.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public boolean search(E value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node<E> root, E value) {
        if (root == null) {
            return false;
        }
        if (value.compareTo(root.data) == 0) {
            return true;
        }
        if (value.compareTo(root.data) < 0) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    public Node<E> delete(E value) {
        return deleteRec(root, value);
    }

    private Node<E> deleteRec(Node<E> root, E value) {
        if (root == null) {
            return null;
        }
        if (value.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private E minValue(Node<E> root) {
        E minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<E> node) {
        if (node == null) {
            return -1; // Return -1 for null nodes
        }
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public String toString() {
        return BTreePrinter.printNode(root);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst);

        System.out.println("Inorder traversal:");
        bst.inorder();

        System.out.println("\n\nDelete 2:");
        bst.delete(2);
        bst.inorder();

        System.out.println("\n\nDelete 3:");
        bst.delete(3);
        bst.inorder();

        System.out.println("\n\nDelete 5:");
        bst.delete(5);
        bst.inorder();
        System.out.println("\n");

        System.out.println(bst);
    }
}
