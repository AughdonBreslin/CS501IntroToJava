package Trees_17;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/12/2025, Saturday
 **/
class RedBlackTree<E extends Comparable<E>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<E> root;

    // Insertion
    public void insert(E data) {
        root = insert(root, data);
        root.color = BLACK; // Root must always be black
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }

        // Fix violations
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    // Deletion
    public void delete(E data) {
        if (root != null) {
            root = delete(root, data);
            if (root != null) {
                root.color = BLACK; // Ensure root is always black
            }
        }
    }

    private Node<E> delete(Node<E> node, E data) {
        if (data.compareTo(node.data) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left)) {
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, data);
        } else {
            if (isRed(node.left)) {
                node = rotateRight(node);
            }
            if (data.compareTo(node.data) == 0 && (node.right == null)) {
                return null;
            }
            if (!isRed(node.right)) {
                node = moveRedRight(node);
            }
            if (data.compareTo(node.data) == 0) {
                Node<E> minNode = getMin(node.right);
                node.data = minNode.data;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right, data);
            }
        }
        return balance(node);
    }

    private boolean isRed(Node<E> node) {
        return (node != null) && (node.color == RED);
    }

    private Node<E> rotateLeft(Node<E> h) {
        Node<E> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<E> rotateRight(Node<E> h) {
        Node<E> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<E> h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node<E> moveRedLeft(Node<E> node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    private Node<E> moveRedRight(Node<E> node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }

    private Node<E> deleteMin(Node<E> node) {
        if (node.left == null) {
            return null;
        }

        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }

    private Node<E> getMin(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node<E> balance(Node<E> node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    @Override
    public String toString() {
        return BTreePrinter.printNode(root);
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(10);
        System.out.println(rbt);

        rbt.insert(5);
        System.out.println(rbt);

        rbt.insert(20);
        System.out.println(rbt);

        rbt.insert(30);
        System.out.println(rbt);

        rbt.insert(15);
        System.out.println(rbt);

        rbt.delete(20);
        System.out.println(rbt);
    }
}
