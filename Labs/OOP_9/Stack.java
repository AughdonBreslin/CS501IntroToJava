package OOP_9;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/17/2025, Monday
 **/
public class Stack {
    private int[] stack;
    private int size;
    public int capacity = 16;

    public Stack() {
        stack = new int[capacity];
    }

    public Stack(int capacity) {
        stack = new int[capacity];
    }

    public void push(int value) {
        // Array is full; upscale
        if (size >= capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
        stack[size] = value;
        size++;
    }

    public int pop() {
        size--;
        int result = stack[size];
        // Array is mostly empty; downscale
        if (size < capacity * 0.2) {
            capacity /= 2;
            int[] temp = new int[capacity];
            System.arraycopy(stack, 0, temp, 0, capacity);
            stack = temp;
        }
        return result;
    }

    public int peek() {
        return stack[size-1];
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
            System.out.printf("Pushed: %d,\tSize: %d,\tCapacity: %d\n", i, stack.getSize(), stack.capacity);
        }
        System.out.println("------------------------------------");
        while (!stack.empty()) {
            System.out.printf("Popped: %d,\tSize: %d,\tCapacity: %d\n", stack.pop(), stack.getSize(), stack.capacity);
        }
    }
}
