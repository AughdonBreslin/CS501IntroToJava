package Queues_16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
public class BasicQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("Apple");
        queue.add("Banana");
        queue.offer("Cherry");

        System.out.println("Queue: " + queue);  // [Apple, Banana, Cherry]

        // Examining front element
        System.out.println("Front element: " + queue.peek());  // Apple

        // Removing elements
        System.out.println("Removed: " + queue.poll());  // Apple
        System.out.println("Queue after removal: " + queue);  // [Banana, Cherry]

        // Queue size
        System.out.println("Queue size: " + queue.size());  // 2

        // Check if empty
        System.out.println("Is queue empty? " + queue.isEmpty());  // false
    }
}
