package Trees_17;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/12/2025, Saturday
 **/
public class AVLTree<E extends Comparable<E>> {

    Node<E> root;

    private int height(Node<E> node) {
        return (node == null) ? 0 : node.height;
    }

    private void updateHeight(Node<E> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    int balanceFactor(Node<E> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node<E> rightRotate(Node<E> y) {
        Node<E> x = y.left;
        Node<E> T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<E> leftRotate(Node<E> x) {
        Node<E> y = x.right;
        Node<E> T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node<E> rebalance(Node<E> node) {
        updateHeight(node);
        int balance = balanceFactor(node);

        // Left Left Case
        if (balance > 1 && node.left != null && node.left.data.compareTo(node.data) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && node.right != null && node.right.data.compareTo(node.data) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && node.left != null && node.left.data.compareTo(node.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && node.right != null && node.right.data.compareTo(node.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            return node; // No duplicates
        }

        return rebalance(node);
    }

    private Node<E> minValueNode(Node<E> right) {
        Node<E> current = right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node<E> delete(Node<E> node, E data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left != null && node.right != null) {
                // Two children: replace with inorder successor
                Node<E> temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            } else {
                Node<E> temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    // No children, delete this node
                    node = null;
                } else {
                    // One child, replace this node with its child
                    node = temp;
                }
            }
        }
        if (node == null) {
            return null; // Tree had only one node
        }
        updateHeight(node);
        return rebalance(node); // Same as insert
    }

    @Override
    public String toString() {
        return BTreePrinter.printNode(root);
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.root = avlTree.insert(avlTree.root, 10);
        System.out.println("AVL Tree after inserting 10:");
        System.out.println(avlTree);

        avlTree.root = avlTree.insert(avlTree.root, 20);
        System.out.println("AVL Tree after inserting 20:");
        System.out.println(avlTree);

        avlTree.root = avlTree.insert(avlTree.root, 30);
        System.out.println("AVL Tree after inserting 30:");
        System.out.println(avlTree);

        avlTree.root = avlTree.insert(avlTree.root, 40);
        System.out.println("AVL Tree after inserting 40:");
        System.out.println(avlTree);

        avlTree.root = avlTree.insert(avlTree.root, 50);
        System.out.println("AVL Tree after inserting 50:");
        System.out.println(avlTree);

        avlTree.root = avlTree.insert(avlTree.root, 25);
        System.out.println("AVL Tree after inserting 25:");
        System.out.println(avlTree);

        avlTree.root = avlTree.delete(avlTree.root, 30);
        System.out.println("AVL Tree after deletion of 30:");
        System.out.println(avlTree);
    }
}
