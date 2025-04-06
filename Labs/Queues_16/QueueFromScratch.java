package Queues_16;

import java.util.Collection;
import java.util.Queue;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
public class QueueFromScratch<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int front;
    private int rear;
    private int size;

    public QueueFromScratch() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public QueueFromScratch(int capacity) {
        elements = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean offer(E e) {
        if (size == elements.length) {
            return false; // Queue is full
        }
        // Wrap front and rear around so we don't need to shift elements
        rear = (rear + 1) % elements.length;
        elements[rear] = e;
        size++;
        return true;
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null; // Queue is empty
        }
        E element = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public E remove() {
        E element = poll();
        if (element == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return element;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null; // Queue is empty
        }
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[(front + i) % elements.length].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[(front + i) % elements.length].equals(o)) {
                // Shift elements to fill the gap
                for (int j = i; j < size - 1; j++) {
                    elements[(front + j) % elements.length] = elements[(front + j + 1) % elements.length];
                }
                rear = (rear - 1 + elements.length) % elements.length;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E element() {
        E element = peek();
        if (element == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return element;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (offer(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[(front + i) % elements.length])) {
                remove(elements[(front + i) % elements.length]);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[(front + i) % elements.length];
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) toArray();
        }
        for (int i = 0; i < size; i++) {
            a[i] = (T) elements[(front + i) % elements.length];
        }
        return a;
    }

    @Override
    public boolean removeIf(java.util.function.Predicate<? super E> filter) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (filter.test(elements[(front + i) % elements.length])) {
                remove(elements[(front + i) % elements.length]);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private int currentIndex = front;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E element = elements[currentIndex];
                currentIndex = (currentIndex + 1) % elements.length;
                count++;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[(front + i) % elements.length]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueFromScratch<Integer> queue = new QueueFromScratch<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue); // Output: Queue: 1 2 3

        queue.poll();
        System.out.println(queue); // Output: Queue: 2 3

        queue.add(4);
        System.out.println(queue); // Output: Queue: 2 3 4

        System.out.println(queue.peek()); // Output: 2
    }
}
