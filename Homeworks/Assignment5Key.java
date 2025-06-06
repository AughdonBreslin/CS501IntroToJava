import java.util.*;
import java.util.function.Predicate;

public class Assignment5Key {

    /**
     * Problem 1: Finds elements common to both sets within a given tolerance.
     * For numbers within ±tolerance of each other, considers them "equal".
     * @param set1 First set of numbers
     * @param set2 Second set of numbers
     * @param tolerance Maximum allowed difference to consider numbers equal
     * @return New set containing numbers from set1 that have matches in set2 within tolerance
     */
    public Set<Double> fuzzyIntersection(Set<Double> set1, Set<Double> set2, double tolerance) {
        Set<Double> result = new HashSet<>();

        for (Double num1 : set1) {
            for (Double num2 : set2) {
                if (Math.abs(num1 - num2) <= tolerance) {
                    result.add(num1); // Add the number from set1
                    break; // Move to next number in set1 after finding a match
                }
            }
        }

        return result;
    }

    /**
     * Problem 2: Partitions a set into two based on a predicate
     * @param originalSet The input set to partition
     * @param predicate // Example predicates: (x -> x > 5), (x -> x % 2 == 0)
     * @return Map with keys "true" and "false" containing partitioned elements
     */
    public <T> Map<Boolean, Set<T>> partitionSet(Set<T> originalSet, Predicate<T> predicate) {
        Map<Boolean, Set<T>> result = new HashMap<>();
        result.put(true, new HashSet<>());
        result.put(false, new HashSet<>());

        for (T element : originalSet) {
            boolean testResult = predicate.test(element);
            result.get(testResult).add(element);
        }

        return result;
    }

    /**
     * Problem 3: Swap keys and values in a map. If duplicate values exist, combine their keys into a set.
     * @param map Input map with keys and values
     * @return New map with values as keys and sets of keys as values
     */
    public <K, V> Map<V, Set<K>> invertMapWithSetValues(Map<K, V> map) {
        Map<V, Set<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new HashSet<>()).add(entry.getKey());
        }
        return inverted;
    }

    /**
     * Problem 4: Count word frequencies in a list. Return a map where keys are words and values are their counts (case-insensitive).
     * @param words List of words
     * @return Map with words as keys and their frequencies as values
     */
    public Map<String, Integer> countWordFrequencies(List<String> words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            freqMap.put(lowerWord, freqMap.getOrDefault(lowerWord, 0) + 1);
        }
        return freqMap;
    }

    /**
     * Problem 5: Reverse a queue using a stack. Modify the input queue to reverse its elements.
     * @param queue Input queue to be reversed
     */
    public <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    /**
     * Problem 6: Find the first non-repeating character in a stream (using a queue).
     * Return the first character that appears only once, or '#' if none exists.
     * @param stream Input string stream
     * @return First non-repeating character or '#' if none exists
     */
    public char firstNonRepeatingChar(String stream) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : stream.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            queue.add(c);
            while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? '#' : queue.peek();
    }

    /**
     * Problem 7: Merge k sorted lists into one sorted list using a priority queue.
     * @param lists List of sorted lists
     * @return Merged sorted list
     */
    public List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (List<Integer> list : lists) {
            minHeap.addAll(list);
        }
        List<Integer> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            merged.add(minHeap.poll());
        }
        return merged;
    }

    /**
     * Problem 8: Find the top k frequent elements using a priority queue.
     * @param nums Input array of integers
     * @param k Number of top frequent elements to find
     * @return List of top k frequent elements
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(freqMap.entrySet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    /**
     * Problem 9: Validate if a binary tree is a BST.
     * @param root Root of the binary tree
     * @return True if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(Node<Integer> root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(Node<Integer> node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBSTHelper(node.left, min, node.data) &&
                isValidBSTHelper(node.right, node.data, max);
    }

    /**
     * Problem 10: Find the kth smallest element in a BST.
     * @param root Root of the BST
     * @param k The kth position to find
     * @return The kth smallest element
     */
    public int kthSmallest(Node<Integer> root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        return inorder.get(k - 1);
    }

    private void inOrderTraversal(Node<Integer> node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }

    // Node class for BST problems
    public static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}