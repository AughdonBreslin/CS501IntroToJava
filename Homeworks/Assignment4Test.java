/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/30/2025, Sunday
 **/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Assignment4Test {
    private final Assignment4Key solution = new Assignment4Key();

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome("racecar"));
        assertTrue(solution.isPalindrome("A man a plan a canal Panama"));
        assertFalse(solution.isPalindrome("hello"));
        assertTrue(solution.isPalindrome(""));
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    void testMergeMaps() {
        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
        Map<String, Integer> map2 = Map.of("b", 3, "c", 4);
        Map<String, Integer> merged = solution.mergeMaps(map1, map2);
        assertEquals(1, merged.get("a"));
        assertEquals(5, merged.get("b"));
        assertEquals(4, merged.get("c"));
    }

    @Test
    void testSymmetricDifference() {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);
        Set<Integer> diff = solution.symmetricDifference(set1, set2);
        assertTrue(diff.contains(1));
        assertTrue(diff.contains(2));
        assertTrue(diff.contains(4));
        assertTrue(diff.contains(5));
        assertFalse(diff.contains(3));
    }

    @Test
    void testDeepReverse() {
        List<Object> list = List.of(1, 2, List.of(3, 4, List.of(5, 6)), 7);
        List<Object> reversed = Assignment4Key.deepReverse(list);
        assertEquals(List.of(7, List.of(List.of(6, 5), 4, 3), 2, 1), reversed);
    }

    @Test
    void testStackReverse() {
        Assignment4Key.MyStack<Integer> stack = new Assignment4Key.MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.reverse();
        assertEquals(1, stack.pop());
    }

    @Test
    void testPowerSet() {
        Set<Integer> set = Set.of(1, 2);
        Set<Set<Integer>> powerSet = solution.powerSet(set);
        assertEquals(4, powerSet.size());
        assertTrue(powerSet.contains(Set.of()));
        assertTrue(powerSet.contains(Set.of(1)));
        assertTrue(powerSet.contains(Set.of(2)));
        assertTrue(powerSet.contains(Set.of(1, 2)));
    }

    @Test
    void testFindPairs() {
        List<Double> list = List.of(1.0, 2.0, 3.0, 4.0);
        Set<Set<Double>> pairs = solution.findPairs(list, 5.0);
        assertEquals(2, pairs.size());
        assertTrue(pairs.contains(Set.of(1.0, 4.0)));
        assertTrue(pairs.contains(Set.of(2.0, 3.0)));
    }

    @Test
    void testIsBalanced() {
        assertTrue(solution.isBalanced("()"));
        assertTrue(solution.isBalanced("([])"));
        assertFalse(solution.isBalanced("([)]"));
        assertFalse(solution.isBalanced("("));
        assertTrue(solution.isBalanced(""));
    }

    @Test
    void testSolveMaze() {
        int[][] maze = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 0}
        };
        boolean[][] visited = new boolean[3][3];
        assertTrue(solution.solveMaze(maze, 0, 0, visited));

        int[][] noPathMaze = {
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 0}
        };
        visited = new boolean[3][3];
        assertFalse(solution.solveMaze(noPathMaze, 0, 0, visited));
    }

    @Test
    void testMirrorTree() {
        Assignment4Key.Node<Integer> root = new Assignment4Key.Node<>(1);
        root.left = new Assignment4Key.Node<>(2);
        root.right = new Assignment4Key.Node<>(3);
        root.left.left = new Assignment4Key.Node<>(4);

        solution.mirrorTree(root);
        assertEquals(3, root.left.data);
        assertEquals(2, root.right.data);
        assertEquals(4, root.right.right.data);
    }
}
