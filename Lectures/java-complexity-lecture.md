# Time and Space Complexity Analysis
## Introduction to Java Programming - Lecture Materials
*Duration: 2.5 hours*

## Table of Contents
1. [Introduction (15 minutes)](#introduction)
2. [Big O Notation Fundamentals (20 minutes)](#big-o-notation-fundamentals)
3. [Common Time Complexities (30 minutes)](#common-time-complexities)
4. [Analyzing Java Code Examples (30 minutes)](#analyzing-java-code-examples)
5. [Break (10 minutes)](#break)
6. [Space Complexity Analysis (20 minutes)](#space-complexity-analysis)
7. [Java Collections Performance (25 minutes)](#java-collections-performance)
8. [Algorithm Analysis Case Studies (25 minutes)](#algorithm-analysis-case-studies)
9. [Practice Problems & Discussion (15 minutes)](#practice-problems--discussion)
10. [Optimization Techniques (10 minutes)](#optimization-techniques)
11. [Conclusion and Q&A (10 minutes)](#conclusion-and-qa)

## Introduction
### What is Computational Complexity?
- **Definition**: The study of the efficiency of algorithms in terms of time and memory usage
- **Why it matters**: Understanding complexity helps us:
  - Choose the right algorithm for a problem
  - Predict performance on large inputs
  - Optimize code efficiently
  - Ace technical interviews

### Real-World Impact
- Example: Facebook friend suggestions - O(n²) vs O(n log n) algorithm
  - When n = millions of users, the difference is hours vs seconds
- Netflix recommendation system performance
- Google search algorithm efficiency

### Course Context
- How complexity analysis fits into your broader computer science education
- Connection to data structures, algorithms, and software engineering
- Industry relevance: coding interviews and professional development

## Big O Notation Fundamentals
### Mathematical Foundation
- **Formal definition**: f(n) = O(g(n)) if there exist constants c > 0 and n₀ such that 0 ≤ f(n) ≤ c·g(n) for all n ≥ n₀
- **Simplified explanation**: Big O describes the upper bound of an algorithm's growth rate
- Focus on dominant terms and worst-case scenarios

### Analyzing Complexity
- Count the operations, not the time
- Focus on how performance scales with input size
- Ignore constants and lower-order terms
- Always consider the worst-case scenario (unless specified otherwise)

### Notation Rules
- Drop constants: O(5n) becomes O(n)
- Drop lower-order terms: O(n² + n) becomes O(n²)
- Addition vs. multiplication:
  - Sequential operations: O(f(n) + g(n))
  - Nested operations: O(f(n) * g(n))

## Common Time Complexities
### O(1) - Constant Time
- Performance doesn't depend on input size
- Java examples:
  ```java
  int first = array[0]; // Array access
  hashMap.put(key, value); // HashMap operations (amortized)
  stack.push(element); // Stack push operation
  ```

### O(log n) - Logarithmic Time
- Divides the problem in half each step
- Java examples:
  ```java
  // Binary search
  public static int binarySearch(int[] arr, int target) {
      int left = 0;
      int right = arr.length - 1;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (arr[mid] == target)
              return mid;
          else if (arr[mid] < target)
              left = mid + 1;
          else
              right = mid - 1;
      }
      
      return -1;
  }
  
  // Operations on balanced binary trees
  TreeMap<Integer, String> map = new TreeMap<>();
  map.put(5, "five"); // O(log n)
  ```

### O(n) - Linear Time
- Performance scales linearly with input size
- Java examples:
  ```java
  // Linear search
  public static int linearSearch(int[] arr, int target) {
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] == target)
              return i;
      }
      return -1;
  }
  
  // Calculating sum
  public static int sum(int[] arr) {
      int total = 0;
      for (int num : arr) {
          total += num;
      }
      return total;
  }
  ```

### O(n log n) - Linearithmic Time
- Common in efficient sorting algorithms
- Java examples:
  ```java
  // Arrays.sort() uses a dual-pivot Quicksort (typically O(n log n))
  int[] numbers = {5, 2, 8, 1, 9};
  Arrays.sort(numbers);
  
  // Merge sort implementation
  public static void mergeSort(int[] arr, int left, int right) {
      if (left < right) {
          int mid = left + (right - left) / 2;
          
          mergeSort(arr, left, mid);
          mergeSort(arr, mid + 1, right);
          
          merge(arr, left, mid, right);
      }
  }
  ```

### O(n²) - Quadratic Time
- Nested iterations over the data
- Java examples:
  ```java
  // Bubble sort
  public static void bubbleSort(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr.length - i - 1; j++) {
              if (arr[j] > arr[j + 1]) {
                  // Swap elements
                  int temp = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = temp;
              }
          }
      }
  }
  
  // Finding all pairs
  public static void printAllPairs(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr.length; j++) {
              System.out.println(arr[i] + ", " + arr[j]);
          }
      }
  }
  ```

### O(2ⁿ) - Exponential Time
- Doubles with each addition to input
- Java examples:
  ```java
  // Recursive Fibonacci
  public static int fibonacci(int n) {
      if (n <= 1)
          return n;
      return fibonacci(n - 1) + fibonacci(n - 2);
  }
  
  // Generating all subsets
  public static void generateSubsets(int[] arr, int index, List<Integer> current) {
      if (index == arr.length) {
          System.out.println(current);
          return;
      }
      
      // Include current element
      current.add(arr[index]);
      generateSubsets(arr, index + 1, current);
      
      // Exclude current element
      current.remove(current.size() - 1);
      generateSubsets(arr, index + 1, current);
  }
  ```

### O(n!) - Factorial Time
- Grows faster than exponential
- Java example:
  ```java
  // Generate all permutations
  public static void generatePermutations(int[] arr, int start) {
      if (start == arr.length - 1) {
          System.out.println(Arrays.toString(arr));
          return;
      }
      
      for (int i = start; i < arr.length; i++) {
          // Swap
          int temp = arr[start];
          arr[start] = arr[i];
          arr[i] = temp;
          
          generatePermutations(arr, start + 1);
          
          // Swap back
          temp = arr[start];
          arr[start] = arr[i];
          arr[i] = temp;
      }
  }
  ```

## Analyzing Java Code Examples
### Step-by-Step Analysis Process
1. Identify the input and its size
2. Count the operations in terms of input size
3. Determine the worst-case scenario
4. Express using Big O notation

### Example 1: Single Loop
```java
public static int findMax(int[] numbers) {
    int max = Integer.MIN_VALUE;
    for (int num : numbers) {
        if (num > max) {
            max = num;
        }
    }
    return max;
}
```
- Analysis:
  - Input size: n (length of array)
  - Loop executes n times
  - Each iteration performs constant-time operations
  - Time complexity: O(n)

### Example 2: Nested Loops
```java
public static boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}
```
- Analysis:
  - Input size: n (length of array)
  - Outer loop: n iterations
  - Inner loop: starts at i+1, ends at n-1
  - Total operations: n + (n-1) + (n-2) + ... + 1 = n(n+1)/2
  - Time complexity: O(n²)

### Example 3: Logarithmic Complexity
```java
public static int binarySearch(int[] sortedArray, int key) {
    int low = 0;
    int high = sortedArray.length - 1;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (sortedArray[mid] == key)
            return mid;
        else if (sortedArray[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    
    return -1;
}
```
- Analysis:
  - Input size: n (length of array)
  - Each iteration, search space is halved
  - Maximum iterations: log₂n
  - Time complexity: O(log n)

### Example 4: Mixed Complexity
```java
public static void processData(int[] array, int[][] matrix) {
    // Part 1: Process array
    for (int num : array) {
        System.out.println(num);
    }
    
    // Part 2: Process matrix
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.println(matrix[i][j]);
        }
    }
}
```
- Analysis:
  - Input sizes: n (array length), m (matrix size: m×m)
  - Part 1: O(n)
  - Part 2: O(m²)
  - Overall complexity: O(n + m²)

## Break
*10-minute break*

## Space Complexity Analysis
### Understanding Space Complexity
- **Definition**: The amount of memory an algorithm needs relative to input size
- **Components**:
  - Input space: Memory needed to store the input
  - Auxiliary space: Extra memory used during execution

### Space Complexity Patterns
- **O(1)** - Constant space:
  ```java
  public static int sum(int[] nums) {
      int result = 0;
      for (int num : nums) {
          result += num;
      }
      return result;
  }
  ```

- **O(n)** - Linear space:
  ```java
  public static int[] duplicate(int[] nums) {
      int[] result = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
          result[i] = nums[i];
      }
      return result;
  }
  ```

- **O(n²)** - Quadratic space:
  ```java
  public static int[][] createMatrix(int n) {
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              matrix[i][j] = i * j;
          }
      }
      return matrix;
  }
  ```

### Recursion and Stack Space
- Each recursive call adds a frame to the call stack
- Example:
  ```java
  public static int factorial(int n) {
      if (n <= 1) return 1;
      return n * factorial(n - 1);
  }
  ```
  - Space complexity: O(n) due to n recursive calls on stack

### Java-Specific Memory Considerations
- Object overhead in Java
- Primitive vs. reference types
- Memory management and garbage collection
- Stack vs. heap allocation

## Java Collections Performance
### Overview of Java Collections Framework
- Hierarchy of interfaces and implementations
- Time and space complexity trade-offs

### ArrayList vs. LinkedList
- **ArrayList**:
  - Access: O(1)
  - Insert/Delete at end: Amortized O(1)
  - Insert/Delete at arbitrary position: O(n)
  - Space: O(n)
  
- **LinkedList**:
  - Access: O(n)
  - Insert/Delete at ends: O(1)
  - Insert/Delete at known position: O(1)
  - Space: O(n) with higher constant factor
  
```java
// ArrayList example
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(1);                // O(1) amortized
arrayList.get(0);                // O(1)
arrayList.add(0, 2);             // O(n)
arrayList.remove(arrayList.size() - 1); // O(1)

// LinkedList example
LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.add(1);               // O(1)
linkedList.getFirst();           // O(1)
linkedList.getLast();            // O(1)
linkedList.get(5);               // O(n)
```

### HashMap vs. TreeMap
- **HashMap**:
  - Put/Get/Remove: O(1) average, O(n) worst case
  - Space: O(n)
  
- **TreeMap**:
  - Put/Get/Remove: O(log n)
  - Space: O(n)
  - Maintains sorted order
  
```java
// HashMap example
HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("one", 1);           // O(1) average
hashMap.get("one");              // O(1) average
hashMap.containsKey("one");      // O(1) average

// TreeMap example
TreeMap<String, Integer> treeMap = new TreeMap<>();
treeMap.put("one", 1);           // O(log n)
treeMap.get("one");              // O(log n)
treeMap.floorKey("one");         // O(log n)
```

### HashSet vs. TreeSet
- **HashSet**:
  - Add/Remove/Contains: O(1) average
  - Space: O(n)
  
- **TreeSet**:
  - Add/Remove/Contains: O(log n)
  - Space: O(n)
  - Maintains sorted order
  
```java
// HashSet example
HashSet<String> hashSet = new HashSet<>();
hashSet.add("apple");            // O(1) average
hashSet.contains("apple");       // O(1) average

// TreeSet example
TreeSet<String> treeSet = new TreeSet<>();
treeSet.add("apple");            // O(log n)
treeSet.contains("apple");       // O(log n)
treeSet.floor("apple");          // O(log n)
```

### Priority Queue
- Implementation: Typically a binary heap
- Operations:
  - Insert: O(log n)
  - Remove min/max: O(log n)
  - Peek: O(1)
  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(3);                       // O(log n)
pq.add(1);
pq.add(2);
pq.peek();                       // O(1)
pq.poll();                       // O(log n)
```

## Algorithm Analysis Case Studies
### Case Study 1: Sorting Algorithms
- **Bubble Sort**
  - Time: O(n²)
  - Space: O(1)
  
- **Merge Sort**
  - Time: O(n log n)
  - Space: O(n)
  
- **Quick Sort**
  - Time: O(n log n) average, O(n²) worst case
  - Space: O(log n) average for recursion stack
  
```java
// Quick Sort implementation
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // Swap arr[i+1] and arr[high] (pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
}
```

### Case Study 2: Graph Algorithms
- **Breadth-First Search (BFS)**
  - Time: O(V + E) where V is vertices, E is edges
  - Space: O(V)
  
- **Depth-First Search (DFS)**
  - Time: O(V + E)
  - Space: O(V) in worst case for recursion stack
  
```java
// BFS implementation
public static void bfs(Graph graph, int startVertex) {
    boolean[] visited = new boolean[graph.getVertexCount()];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[startVertex] = true;
    queue.add(startVertex);
    
    while (!queue.isEmpty()) {
        int vertex = queue.poll();
        System.out.print(vertex + " ");
        
        for (int neighbor : graph.getAdjacencyList()[vertex]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```

### Case Study 3: Dynamic Programming
- Fibonacci sequence: Recursive vs. Memoized vs. Iterative
- Recursive: O(2ⁿ) time, O(n) space
- Memoized: O(n) time, O(n) space
- Iterative: O(n) time, O(1) space

```java
// Recursive (exponential time)
public static int fibRecursive(int n) {
    if (n <= 1) return n;
    return fibRecursive(n - 1) + fibRecursive(n - 2);
}

// Memoized (linear time)
public static int fibMemoized(int n, Integer[] memo) {
    if (memo[n] != null) return memo[n];
    if (n <= 1) return n;
    
    memo[n] = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
    return memo[n];
}

// Iterative (linear time, constant space)
public static int fibIterative(int n) {
    if (n <= 1) return n;
    
    int prev = 0;
    int current = 1;
    
    for (int i = 2; i <= n; i++) {
        int next = prev + current;
        prev = current;
        current = next;
    }
    
    return current;
}
```

## Practice Problems & Discussion
### Problem 1: Find Time Complexity
```java
public static boolean isUnique(String str) {
    for (int i = 0; i < str.length(); i++) {
        for (int j = i + 1; j < str.length(); j++) {
            if (str.charAt(i) == str.charAt(j)) {
                return false;
            }
        }
    }
    return true;
}
```
- Discussion: What's the time complexity? Space complexity?
- Answer: O(n²) time, O(1) space

### Problem 2: Optimize Algorithm
```java
// Original algorithm - O(n²)
public static boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}

// Optimized version - O(n)
public static boolean containsDuplicateOptimized(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    return false;
}
```
- Discussion: Time/space trade-off?
- Answer: Time improved to O(n), space increased to O(n)

### Problem 3: Analyze Recursive Algorithm
```java
public static int mystery(int n) {
    if (n <= 0) return 0;
    return mystery(n/2) + n;
}
```
- Discussion: What's the time complexity? What does this function do?
- Answer: O(log n) time, O(log n) space; calculates sum of powers of 2 less than n

### Problem 4: Java Collections
```java
ArrayList<Integer> list = new ArrayList<>();
for (int i = 0; i < n; i++) {
    list.add(0, i); // Insert at beginning
}
```
- Discussion: What's the time complexity?
- Answer: O(n²) due to shifting elements on each insertion

## Optimization Techniques
### Time-Space Trade-offs
- Using extra space to reduce time complexity
- Example: Memoization in dynamic programming
- Example: Hash tables for O(1) lookups

### Algorithm Selection Guidelines
- Small data: Simplicity > Efficiency
- Large data: Consider asymptotic complexity
- Memory constraints: Consider space complexity
- Sorted data: Can unlock more efficient algorithms

### Common Optimizations in Java
- Avoid unnecessary object creation
- Prefer primitives over wrapper classes when possible
- Use StringBuilder for string concatenation
- Choose appropriate collection types
- Bulk operations vs. individual operations

### Performance Testing
- Microbenchmarking with JMH
- Profiling tools
- Big O isn't everything: constant factors matter

## Conclusion and Q&A
### Key Takeaways
- Time and space complexity are crucial concepts for efficient programming
- Big O notation provides a standardized way to analyze algorithms
- Different data structures and algorithms have different complexity profiles
- Always consider both theoretical complexity and practical performance

### Further Learning Resources
- "Introduction to Algorithms" by CLRS
- "Algorithms" by Robert Sedgewick and Kevin Wayne
- LeetCode, HackerRank, and other coding practice platforms
- Advanced Java courses focusing on optimization

### Q&A Session
- Open floor for questions
- Review of complex topics
- Discussion of real-world applications
