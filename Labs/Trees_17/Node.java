package Trees_17;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/12/2025, Saturday
 **/
public class Node<E extends Comparable<E>> {
    E data;
    int height;
    boolean color; // true for RED, false for BLACK
    Node<E> left;
    Node<E> right;

    public Node(E data) {
        this.data = data;
        this.height = 1; // New node is initially added at leaf
    }
}
