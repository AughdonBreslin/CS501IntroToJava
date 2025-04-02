import java.util.*;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class Assignment4Key {

    /*
     * Problem 1: Recursive Palindrome Checker: Write a recursive method 'isPalindrome' to check if a string is a palindrome.
     * Ignore case, nonalphanumeric characters, and whitespace.
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    // TODO: Implement the isPalindrome method
    public boolean isPalindrome(String str) {
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    private boolean isPalindromeHelper(String str, int left, int right) {
        // Base case: if the left index crosses the right index, it's a palindrome
        if (left >= right) {
            return true;
        }
        // Ignore non-alphanumeric characters and whitespace
        while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
            left++;
        }
        while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
            right--;
        }
        // Compare characters ignoring case
        if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
            return false;
        }
        // Recursive call
        return isPalindromeHelper(str, left + 1, right - 1);
    }

    /*
     * Problem 2: Map Merging: Merge two Map<String, Integer> objects into one via a 'mergeMaps' function. If a key exists in both maps, sum the values.
     * @param map1 the first map
     * @param map2 the second map
     * @return the merged map
     */
    // TODO: Implement the mergeMaps method
    public Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return mergedMap;
    }

    /*
     * Problem 3: Set Symmetric Difference: Given two sets, return their symmetric difference (elements in either set but not both).
     * @param set1 the first set
     * @param set2 the second set
     * @return the symmetric difference
     */
    public <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        union.removeAll(intersection);
        return union;
    }

    /*
     * Problem 4: Deep List Reversal: Given a list that can contain other lists, write a recursive method to reverse the list and all its internal, potentially infinitely deep sublists.
     * @param list the list to reverse
     * @return the reversed list
     */
    public static List<Object> deepReverse(List<Object> list) {
        // TODO: Implement the deepReverse method
        // Base case: if list is empty, return it as-is
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a new list to hold the reversed elements
        List<Object> reversed = new ArrayList<>();

        // Iterate through the original list in reverse order
        for (int i = list.size() - 1; i >= 0; i--) {
            Object element = list.get(i);

            if (element instanceof List) {
                //
                // If the element is a sublist, recursively reverse it
                List<Object> reversedSublist = deepReverse((List<Object>) element);
                reversed.add(reversedSublist);
            } else {
                // If it's a normal element, add it directly
                reversed.add(element);
            }
        }

        return reversed;
    }

    /*
     * Problem 5: Create a generic MyStack<T> class and implement a recursive method to reverse its elements.
     * For testing, if you need to implement other functions, feel free to refer to code discussed in past lectures.
     * The MyStack should be implemented using a List<T> elements.
     */
    // TODO: Create public static MyStack class, implement:
    //  public void push(T element) method
    //  public T pop() method
    //  public void reverse() method
    public static class MyStack<T> {
        private List<T> elements = new ArrayList<>();
        public void push(T element) {
            elements.add(element);
        }
        public T pop() {
            if (elements.isEmpty()) {
                throw new EmptyStackException();
            }
            return elements.removeLast();
        }
        public void reverse() {
            if (!elements.isEmpty()) {
                T temp = elements.removeFirst();
                reverse();
                elements.add(temp);
            }
        }
    }

    /*
     * Problem 6: Given a Set<T>, return all possible subsets (the power set) using recursion.
     * @param originalSet the original set
     * @return the power set of the original set
     */
    public <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        // TODO: Implement the powerSet method
        Set<Set<T>> result = new HashSet<>();
        if (originalSet.isEmpty()) {
            result.add(new HashSet<>());
            return result;
        }
        List<T> list = new ArrayList<>(originalSet);
        T firstElement = list.getFirst();
        Set<T> remainingSet = new HashSet<>(list.subList(1, list.size()));
        for (Set<T> subset : powerSet(remainingSet)) {
            Set<T> newSubset = new HashSet<>(subset);
            newSubset.add(firstElement);
            result.add(newSubset);
            result.add(subset);
        }
        return result;
    }

    /*
     * Problem 7: Given a List<Double> and a target value, find all unique pairs (a, b) that sum to the target using a Set.
     * @param list the list of numbers
     * @param target the target sum
     * @return a set of unique pairs that sum to the target
     */
    public Set<Set<Double>> findPairs(List<Double> list, Double target) {
        // TODO: Implement the findPairs method
        Set<Set<Double>> result = new HashSet<>();
        Set<Double> seen = new HashSet<>();
        for (Double number : list) {
            double complement = target - number;
            if (seen.contains(complement)) {
                Set<Double> pair = new HashSet<>();
                pair.add(number);
                pair.add(complement);
                result.add(pair);
            }
            seen.add(number);
        }
        return result;
    }

    /*
     * Problem 8: Balanced Parentheses Checker: Use recursion to check if a string of parentheses is balanced.
     * Balanced parentheses means that every opening parenthesis has a corresponding closing parenthesis that properly follows.
     * ie. "(()())" is balanced, but "(()", "[{]}", and "())(" are not.
     * Valid parentheses include: (), [], {}, and <>.
     * @param str the string to check
     * @return true if the string is balanced, false otherwise
     */
    public boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}') ||
                (opening == '<' && closing == '>');
    }

    /*
     * Problem 9: Recursive Maze Solver: Given a 2D grid (0 = path, 1 = wall), write a recursive method to find is a path exists from the top-left to the bottom0-right corner.
     * @param maze the 2D grid
     * @param x the current x position
     * @param y the current y position
     * @param visited a 2D array to keep track of visited positions
     * @return true if a path exists, false otherwise
     */
    public boolean solveMaze(int[][] maze, int x, int y, boolean[][] visited) {
        // Check if the current position is out of bounds or a wall
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1 || visited[x][y]) {
            return false;
        }
        // Check if we have reached the bottom-right corner
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return true;
        }
        // Mark the current position as visited
        visited[x][y] = true;
        // Recursively check all four directions
        boolean foundPath = solveMaze(maze, x + 1, y, visited) ||
                            solveMaze(maze, x - 1, y, visited) ||
                            solveMaze(maze, x, y + 1, visited) ||
                            solveMaze(maze, x, y - 1, visited);
        // Unmark the current position (backtrack)
        visited[x][y] = false;
        return foundPath;
    }



    /*
     * Problem 10: Recursive Tree Mirroring: Given a binary tree (as a nested Node class), recursively mirror it (swap left/right subtreees).
     * @param root the root of the binary tree
     */
    public <T> void mirrorTree(Node<T> root) {
        // TODO: Implement the mirrorTree method
        if (root == null) {
            return;
        }
        // Swap the left and right subtrees
        Node<T> temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Recursively mirror the left and right subtrees
        mirrorTree(root.left);
        mirrorTree(root.right);
    }
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
