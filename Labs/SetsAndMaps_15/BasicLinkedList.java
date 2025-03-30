package SetsAndMaps_15;

import java.util.LinkedList;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListFromScratch {
    public static void main(String[] args) {
        // Create the nodes
        Node head = new Node("Red");
        Node second = new Node("Green");
        Node third = new Node("Blue");

        // Link the nodes
        head.next = second;
        second.next = third;

        // Traverse and print the list
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class BasicLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        // Print the list
        for (String color : list) {
            System.out.println(color);
        }

        // Remove an element
        list.remove("Green");
        System.out.println("After removal: " + list);
    }
}