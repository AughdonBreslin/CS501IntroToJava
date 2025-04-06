package Queues_16;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
/**
 * A priority queue implementation using a binary min-heap.
 * Elements with the lowest values have the highest priority.
 */
public class PriorityQueueFromScratch<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] heap;


    private int size;

    /**
     * Constructs an empty priority queue with default capacity.
     */
    @SuppressWarnings("unchecked")
    public PriorityQueueFromScratch() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an element to the priority queue.
     * @param element The element to add
     */
    public void add(T element) {
        if (size >= heap.length) {
            expandCapacity();
        }

        // Add element at the end
        heap[size] = element;

        // Bubble up to maintain heap property
        bubbleUp(size);

        size++;
    }

    /**
     * Removes and returns the highest priority element.
     * @return The highest priority element (minimum value)
     * @throws IllegalStateException if the queue is empty
     */
    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T min = heap[0];

        // Move the last element to the root
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        // Bubble down to maintain heap property
        if (size > 0) {
            bubbleDown(0);
        }

        return min;
    }

    /**
     * Returns the highest priority element without removing it.
     * @return The highest priority element (minimum value)
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[0];
    }

    /**
     * Checks if the priority queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the queue.
     * @return The size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Doubles the capacity of the heap array.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newHeap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    /**
     * Maintains heap property by bubbling an element up.
     * @param index The index of the element to bubble up
     */
    private void bubbleUp(int index) {
        int parentIndex = getParentIndex(index);

        // If we're at the root or parent has higher priority, we're done
        if (index == 0 || heap[parentIndex].compareTo(heap[index]) <= 0) {
            return;
        }

        // Swap with parent
        T temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;

        // Continue bubbling up
        bubbleUp(parentIndex);
    }

    /**
     * Maintains heap property by bubbling an element down.
     * @param index The index of the element to bubble down
     */
    private void bubbleDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallestIndex = index;

        // Find the smallest of the node and its children
        if (leftChildIndex < size && heap[leftChildIndex].compareTo(heap[smallestIndex]) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[smallestIndex]) < 0) {
            smallestIndex = rightChildIndex;
        }

        // If one of the children is smaller, swap and continue bubbling down
        if (smallestIndex != index) {
            T temp = heap[index];
            heap[index] = heap[smallestIndex];
            heap[smallestIndex] = temp;

            bubbleDown(smallestIndex);
        }
    }

    /**
     * Calculates the parent index in the binary heap.
     * @param childIndex The index of the child
     * @return The index of the parent
     */
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /**
     * Calculates the left child index in the binary heap.
     * @param parentIndex The index of the parent
     * @return The index of the left child
     */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    /**
     * Calculates the right child index in the binary heap.
     * @param parentIndex The index of the parent
     * @return The index of the right child
     */
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    /**
     * Builds a heap from an array of elements.
     * @param elements The array of elements to heapify
     */
    public void heapify(T[] elements) {
        if (elements.length > heap.length) {
            heap = (T[]) new Comparable[elements.length];
        }
        System.arraycopy(elements, 0, heap, 0, elements.length);
        size = elements.length;

        // Start from the last non-leaf node and bubble down
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            bubbleDown(i);
        }
    }

    /**
     * Returns the string representation of the priority queue.
     * @return A string representation of the priority queue
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueue: [");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Test driver for the PriorityQueue.
     */
    public static void main(String[] args) {
        PriorityQueueFromScratch<Integer> pq = new PriorityQueueFromScratch<>();

        // Add elements
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);
        pq.add(10);
        pq.add(3);

        System.out.println("Priority Queue size: " + pq.size());
        System.out.println("Highest priority element: " + pq.peek());

        System.out.println("\nRemoving elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // Test heapify
        Integer[] elements = {7, 4, 6, 2, 9, 1};
        System.out.println("\nOriginal elements:");
        for (Integer element : elements) {
            System.out.print(element + " ");
        }
        pq.heapify(elements);
        System.out.println("\nHeapified elements:\n" + pq);
    }
}
