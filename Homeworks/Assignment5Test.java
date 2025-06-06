import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author: Aughdon Breslin
 * @class: CS501 Intro to Java
 * @description: Test cases for Assignment5
 * @date: 5/11/2025, Sunday
 **/

public class Assignment5Test {
    private final Assignment5Key solution = new Assignment5Key();

    @BeforeAll
    static void setup() {
        System.out.println("Starting test suite...");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("\nRunning test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void countAssertions(TestInfo testInfo) {
        System.out.println("Finished: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void summary() {
        System.out.println("\n=== Test Summary ===");
        System.out.println("Total assertions in test suite: " + 100);
    }

    @Test
    @DisplayName("Test fuzzyIntersection: basic case")
    void testFuzzyIntersection1() {
        Set<Double> set1 = Set.of(1.0, 2.0, 3.0);
        Set<Double> set2 = Set.of(1.1, 2.9, 4.0);
        Set<Double> result = solution.fuzzyIntersection(set1, set2, 0.2);
        assertEquals(Set.of(1.0, 3.0), result);
    }

    @Test
    @DisplayName("Test fuzzyIntersection: no matches")
    void testFuzzyIntersection2() {
        Set<Double> set1 = Set.of(1.0, 2.0, 3.0);
        Set<Double> set2 = Set.of(4.0, 5.0, 6.0);
        Set<Double> result = solution.fuzzyIntersection(set1, set2, 0.5);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test fuzzyIntersection: exact matches")
    void testFuzzyIntersection3() {
        Set<Double> set1 = Set.of(1.0, 2.0, 3.0);
        Set<Double> set2 = Set.of(1.0, 2.0, 3.0);
        Set<Double> result = solution.fuzzyIntersection(set1, set2, 0.0);
        assertEquals(Set.of(1.0, 2.0, 3.0), result);
    }

    @Test
    @DisplayName("Test fuzzyIntersection: empty sets")
    void testFuzzyIntersection4() {
        Set<Double> set1 = Set.of();
        Set<Double> set2 = Set.of(1.0, 2.0);
        Set<Double> result = solution.fuzzyIntersection(set1, set2, 0.5);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test fuzzyIntersection: large tolerance")
    void testFuzzyIntersection5() {
        Set<Double> set1 = Set.of(1.0, 5.0, 10.0);
        Set<Double> set2 = Set.of(3.0, 7.0, 12.0);
        Set<Double> result = solution.fuzzyIntersection(set1, set2, 2.1);
        assertEquals(Set.of(1.0, 5.0, 10.0), result);
    }

    @Test
    @DisplayName("Test partitionSet: even numbers")
    void testPartitionSet1() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Map<Boolean, Set<Integer>> result = solution.partitionSet(set, isEven);
        assertEquals(Set.of(2, 4, 6), result.get(true));
        assertEquals(Set.of(1, 3, 5), result.get(false));
    }

    @Test
    @DisplayName("Test partitionSet: greater than 5")
    void testPartitionSet2() {
        Set<Integer> set = Set.of(3, 5, 7, 9);
        Predicate<Integer> greaterThan5 = x -> x > 5;
        Map<Boolean, Set<Integer>> result = solution.partitionSet(set, greaterThan5);
        assertEquals(Set.of(7, 9), result.get(true));
        assertEquals(Set.of(3, 5), result.get(false));
    }

    @Test
    @DisplayName("Test partitionSet: empty set")
    void testPartitionSet3() {
        Set<String> set = Set.of();
        Predicate<String> isEmpty = String::isEmpty;
        Map<Boolean, Set<String>> result = solution.partitionSet(set, isEmpty);
        assertTrue(result.get(true).isEmpty());
        assertTrue(result.get(false).isEmpty());
    }

    @Test
    @DisplayName("Test partitionSet: all true")
    void testPartitionSet4() {
        Set<Integer> set = Set.of(2, 4, 6, 8);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Map<Boolean, Set<Integer>> result = solution.partitionSet(set, isEven);
        assertEquals(set, result.get(true));
        assertTrue(result.get(false).isEmpty());
    }

    @Test
    @DisplayName("Test partitionSet: string length")
    void testPartitionSet5() {
        Set<String> set = Set.of("a", "ab", "abc", "abcd");
        Predicate<String> lengthGreaterThan2 = s -> s.length() > 2;
        Map<Boolean, Set<String>> result = solution.partitionSet(set, lengthGreaterThan2);
        assertEquals(Set.of("abc", "abcd"), result.get(true));
        assertEquals(Set.of("a", "ab"), result.get(false));
    }

    @Test
    @DisplayName("Test invertMapWithSetValues: basic case")
    void testInvertMapWithSetValues1() {
        Map<String, Integer> map = Map.of(
                "a", 1,
                "b", 2,
                "c", 1
        );
        Map<Integer, Set<String>> result = solution.invertMapWithSetValues(map);
        assertEquals(Set.of("a", "c"), result.get(1));
        assertEquals(Set.of("b"), result.get(2));
    }

    @Test
    @DisplayName("Test invertMapWithSetValues: all unique values")
    void testInvertMapWithSetValues2() {
        Map<String, Integer> map = Map.of(
                "a", 1,
                "b", 2,
                "c", 3
        );
        Map<Integer, Set<String>> result = solution.invertMapWithSetValues(map);
        assertEquals(Set.of("a"), result.get(1));
        assertEquals(Set.of("b"), result.get(2));
        assertEquals(Set.of("c"), result.get(3));
    }

    @Test
    @DisplayName("Test invertMapWithSetValues: empty map")
    void testInvertMapWithSetValues3() {
        Map<String, Integer> map = Map.of();
        Map<Integer, Set<String>> result = solution.invertMapWithSetValues(map);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test invertMapWithSetValues: all same values")
    void testInvertMapWithSetValues4() {
        Map<String, Integer> map = Map.of(
                "a", 1,
                "b", 1,
                "c", 1
        );
        Map<Integer, Set<String>> result = solution.invertMapWithSetValues(map);
        assertEquals(Set.of("a", "b", "c"), result.get(1));
    }

    @Test
    @DisplayName("Test countWordFrequencies: basic case")
    void testCountWordFrequencies1() {
        List<String> words = List.of("Hello", "hello", "world", "World", "world");
        Map<String, Integer> result = solution.countWordFrequencies(words);
        assertEquals(2, result.get("hello"));
        assertEquals(3, result.get("world"));
    }

    @Test
    @DisplayName("Test countWordFrequencies: empty list")
    void testCountWordFrequencies2() {
        List<String> words = List.of();
        Map<String, Integer> result = solution.countWordFrequencies(words);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test countWordFrequencies: all unique words")
    void testCountWordFrequencies3() {
        List<String> words = List.of("a", "b", "c");
        Map<String, Integer> result = solution.countWordFrequencies(words);
        assertEquals(1, result.get("a"));
        assertEquals(1, result.get("b"));
        assertEquals(1, result.get("c"));
    }

    @Test
    @DisplayName("Test countWordFrequencies: all same word")
    void testCountWordFrequencies4() {
        List<String> words = List.of("a", "a", "a");
        Map<String, Integer> result = solution.countWordFrequencies(words);
        assertEquals(3, result.get("a"));
    }

    @Test
    @DisplayName("Test reverseQueue: basic case")
    void testReverseQueue1() {
        Queue<Integer> queue = new LinkedList<>(List.of(1, 2, 3, 4));
        solution.reverseQueue(queue);
        assertEquals(List.of(4, 3, 2, 1), new ArrayList<>(queue));
    }

    @Test
    @DisplayName("Test reverseQueue: empty queue")
    void testReverseQueue2() {
        Queue<Integer> queue = new LinkedList<>();
        solution.reverseQueue(queue);
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Test reverseQueue: single element")
    void testReverseQueue3() {
        Queue<Integer> queue = new LinkedList<>(List.of(1));
        solution.reverseQueue(queue);
        assertEquals(List.of(1), new ArrayList<>(queue));
    }

    @Test
    @DisplayName("Test reverseQueue: already reversed")
    void testReverseQueue4() {
        Queue<Integer> queue = new LinkedList<>(List.of(4, 3, 2, 1));
        solution.reverseQueue(queue);
        assertEquals(List.of(1, 2, 3, 4), new ArrayList<>(queue));
    }

    @Test
    @DisplayName("Test firstNonRepeatingChar: basic case")
    void testFirstNonRepeatingChar1() {
        assertEquals('b', solution.firstNonRepeatingChar("aab"));
    }

    @Test
    @DisplayName("Test firstNonRepeatingChar: all repeating")
    void testFirstNonRepeatingChar2() {
        assertEquals('#', solution.firstNonRepeatingChar("aabb"));
    }

    @Test
    @DisplayName("Test firstNonRepeatingChar: empty string")
    void testFirstNonRepeatingChar3() {
        assertEquals('#', solution.firstNonRepeatingChar(""));
    }

    @Test
    @DisplayName("Test firstNonRepeatingChar: single character")
    void testFirstNonRepeatingChar4() {
        assertEquals('a', solution.firstNonRepeatingChar("a"));
    }

    @Test
    @DisplayName("Test firstNonRepeatingChar: mixed characters")
    void testFirstNonRepeatingChar5() {
        assertEquals('c', solution.firstNonRepeatingChar("aabbc"));
    }

    @Test
    @DisplayName("Test mergeKSortedLists: basic case")
    void testMergeKSortedLists1() {
        List<List<Integer>> lists = List.of(
                List.of(1, 4, 5),
                List.of(1, 3, 4),
                List.of(2, 6)
        );
        List<Integer> result = solution.mergeKSortedLists(lists);
        assertEquals(List.of(1, 1, 2, 3, 4, 4, 5, 6), result);
    }

    @Test
    @DisplayName("Test mergeKSortedLists: empty lists")
    void testMergeKSortedLists2() {
        List<List<Integer>> lists = List.of(
                List.of(),
                List.of(),
                List.of()
        );
        List<Integer> result = solution.mergeKSortedLists(lists);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test mergeKSortedLists: single list")
    void testMergeKSortedLists3() {
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3)
        );
        List<Integer> result = solution.mergeKSortedLists(lists);
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    @DisplayName("Test mergeKSortedLists: lists with duplicates")
    void testMergeKSortedLists4() {
        List<List<Integer>> lists = List.of(
                List.of(1, 1, 2),
                List.of(1, 3, 3)
        );
        List<Integer> result = solution.mergeKSortedLists(lists);
        assertEquals(List.of(1, 1, 1, 2, 3, 3), result);
    }

    @Test
    @DisplayName("Test topKFrequent: basic case")
    void testTopKFrequent1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> result = solution.topKFrequent(nums, 2);
        assertEquals(List.of(1, 2), result);
    }

    @Test
    @DisplayName("Test topKFrequent: all same elements")
    void testTopKFrequent2() {
        int[] nums = {1, 1, 1, 1};
        List<Integer> result = solution.topKFrequent(nums, 1);
        assertEquals(List.of(1), result);
    }

    @Test
    @DisplayName("Test topKFrequent: k equals array length")
    void testTopKFrequent3() {
        int[] nums = {1, 2, 3};
        List<Integer> result = solution.topKFrequent(nums, 3);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(1, 2, 3)));
    }

    @Test
    @DisplayName("Test isValidBST: valid BST")
    void testIsValidBST1() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(2);
        root.left = new Assignment5Key.Node<>(1);
        root.right = new Assignment5Key.Node<>(3);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Test isValidBST: invalid BST")
    void testIsValidBST2() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(5);
        root.left = new Assignment5Key.Node<>(1);
        root.right = new Assignment5Key.Node<>(4);
        root.right.left = new Assignment5Key.Node<>(3);
        root.right.right = new Assignment5Key.Node<>(6);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Test isValidBST: single node")
    void testIsValidBST3() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(1);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Test isValidBST: empty tree")
    void testIsValidBST4() {
        assertTrue(solution.isValidBST(null));
    }

    @Test
    @DisplayName("Test kthSmallest: basic case")
    void testKthSmallest1() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(3);
        root.left = new Assignment5Key.Node<>(1);
        root.right = new Assignment5Key.Node<>(4);
        root.left.right = new Assignment5Key.Node<>(2);
        assertEquals(1, solution.kthSmallest(root, 1));
        assertEquals(2, solution.kthSmallest(root, 2));
        assertEquals(3, solution.kthSmallest(root, 3));
        assertEquals(4, solution.kthSmallest(root, 4));
    }

    @Test
    @DisplayName("Test kthSmallest: single node")
    void testKthSmallest2() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(1);
        assertEquals(1, solution.kthSmallest(root, 1));
    }

    @Test
    @DisplayName("Test kthSmallest: complete BST")
    void testKthSmallest3() {
        Assignment5Key.Node<Integer> root = new Assignment5Key.Node<>(4);
        root.left = new Assignment5Key.Node<>(2);
        root.right = new Assignment5Key.Node<>(6);
        root.left.left = new Assignment5Key.Node<>(1);
        root.left.right = new Assignment5Key.Node<>(3);
        root.right.left = new Assignment5Key.Node<>(5);
        root.right.right = new Assignment5Key.Node<>(7);
        assertEquals(4, solution.kthSmallest(root, 4));
    }
}