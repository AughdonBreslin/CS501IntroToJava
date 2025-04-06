# Introduction to Queues and Priority Queues in Java
## 2.5 Hour Lecture

---

## Table of Contents
1. [Introduction to Queues](#introduction-to-queues)
2. [Queue ADT and Operations](#queue-adt-and-operations)
3. [Queue Implementation in Java](#queue-implementation-in-java)
4. [Queue Applications](#queue-applications)
5. [Priority Queues](#priority-queues)
6. [Priority Queue Implementation in Java](#priority-queue-implementation-in-java)
7. [Heap Data Structure](#heap-data-structure)
8. [Priority Queue Applications](#priority-queue-applications)
9. [Performance Considerations](#performance-considerations)
10. [Practical Examples](#practical-examples)
11. [Common Errors and Debugging](#common-errors-and-debugging)
12. [Practice Problems](#practice-problems)

---

## Introduction to Queues
*[15 minutes]*

### What is a Queue?
A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed.

### Real-World Queue Examples
- People standing in line at a ticket counter
- Print jobs sent to a printer
- Vehicles at a toll booth
- Customers on hold for customer service
- Processes waiting for execution in a computer system

### Queue vs. Stack
| Queue | Stack |
|-------|-------|
| FIFO (First-In-First-Out) | LIFO (Last-In-First-Out) |
| Elements removed in the order they were added | Most recently added element is removed first |
| Like a line of people | Like a stack of plates |
| Insertion at rear, deletion at front | Both insertion and deletion at the same end |

### Queue Terminology
- **Front/Head**: The element that will be dequeued (removed) next
- **Rear/Tail**: The position where the newest element is enqueued (added)
- **Enqueue**: The operation of adding an element to the rear of the queue
- **Dequeue**: The operation of removing an element from the front of the queue

---

## Queue ADT and Operations
*[20 minutes]*

### Abstract Data Type (ADT)
A queue is an abstract data type defined by its behavior:
- Stores elements in a sequential manner
- Elements are processed in FIFO order
- Provides specific operations without specifying implementation details

### Basic Queue Operations
1. **enqueue(element)**: Add an element to the rear of the queue
2. **dequeue()**: Remove and return the element at the front of the queue
3. **peek()** or **front()**: View the element at the front without removing it
4. **isEmpty()**: Check if the queue has no elements
5. **size()**: Return the number of elements in the queue

### Queue State Conditions
- **Empty Queue**: No elements in the queue
- **Full Queue**: Queue has reached its capacity (in bounded implementations)
- **Overflow**: Attempt to enqueue into a full queue
- **Underflow**: Attempt to dequeue from an empty queue

### Queue Operation Examples

```
Initial Queue: []
enqueue(10) → [10]
enqueue(20) → [10, 20]
enqueue(30) → [10, 20, 30]
peek() → 10 (Queue remains [10, 20, 30])
dequeue() → 10 (Queue becomes [20, 30])
dequeue() → 20 (Queue becomes [30])
size() → 1
isEmpty() → false
dequeue() → 30 (Queue becomes [])
isEmpty() → true
```

---

## Queue Implementation in Java
*[30 minutes]*

### Java Collections Framework Queue Interface
Java provides a `Queue` interface in the `java.util` package:

```java
public interface Queue<E> extends Collection<E> {
    // Basic operations
    boolean add(E e);     // Adds an element, throws exception if no space
    boolean offer(E e);   // Adds an element, returns false if no space
    E remove();           // Removes and returns head, throws exception if empty
    E poll();             // Removes and returns head, returns null if empty
    E element();          // Retrieves but doesn't remove head, throws exception if empty
    E peek();             // Retrieves but doesn't remove head, returns null if empty
}
```

### Queue Implementations in Java

1. **LinkedList**
   ```java
   import java.util.LinkedList;
   import java.util.Queue;
   
   Queue<String> queue = new LinkedList<>();
   ```

2. **ArrayDeque**
   ```java
   import java.util.ArrayDeque;
   import java.util.Queue;
   
   Queue<String> queue = new ArrayDeque<>();
   ```

### Methods Comparison: Exception vs. Special Value

| Throws Exception | Returns Special Value | Description |
|------------------|----------------------|-------------|
| add(e)           | offer(e)             | Add element |
| remove()         | poll()               | Remove head |
| element()        | peek()               | Examine head |

### Basic Queue Operations Example

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
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
```

### Array-Based Queue Implementation

```java
public class ArrayQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int front;
    private int rear;
    private int size;
    
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(E element) {
        if (size == elements.length) {
            resize();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }
    
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }
    
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newElements = (E[]) new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
}
```

### Circular Queue Concept
- Efficient array-based implementation
- Avoids shifting elements by wrapping around
- Uses modulo arithmetic to handle wrapping
- Better space utilization than simple array implementation

---

## Queue Applications
*[15 minutes]*

### Common Applications of Queues

1. **Process Scheduling**
   - Operating systems use queues to manage processes waiting for CPU time
   - First-come, first-served scheduling uses basic queues

2. **Buffering and Synchronization**
   - Data buffers between producers and consumers
   - Message queues in distributed systems
   - Event handling in GUI applications

3. **Breadth-First Search (BFS)**
   - Graph traversal algorithm using queues to explore nodes level by level

4. **Resource Allocation**
   - Managing shared resources like printers, disk storage, CPU

5. **Web Servers**
   - Request handling: incoming HTTP requests are queued and processed

### Example: BFS Implementation Using Queue

```java
import java.util.*;

public class BFSExample {
    public static void bfs(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            List<Integer> neighbors = graph.getNeighbors(vertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
```

---

## Priority Queues
*[20 minutes]*

### What is a Priority Queue?
A priority queue is a queue where elements have associated priorities and are served based on their priority rather than their arrival order.

### Characteristics
- Elements are dequeued based on their priority, not their insertion order
- Higher priority elements are dequeued before lower priority elements
- If priorities are equal, often follows FIFO behavior (implementation-dependent)

### Priority Queue vs. Standard Queue

| Standard Queue | Priority Queue |
|----------------|----------------|
| FIFO order | Priority order |
| First element inserted is first out | Highest priority element is first out |
| No notion of element importance | Elements have associated priorities |
| Like a line at a ticket counter | Like a hospital emergency room triage |

### Priority Queue Operations
1. **insert(element, priority)**: Add an element with a specified priority
2. **deleteMax()** or **deleteMin()**: Remove and return the highest/lowest priority element
3. **peek()**: View the highest/lowest priority element without removing it
4. **isEmpty()**: Check if the priority queue has no elements
5. **size()**: Return the number of elements in the priority queue

### Min-Priority vs. Max-Priority Queues
- **Min-Priority Queue**: Lower numerical value indicates higher priority
- **Max-Priority Queue**: Higher numerical value indicates higher priority

### Priority Queue Applications
- Task scheduling in operating systems
- Dijkstra's shortest path algorithm
- Huffman coding compression algorithm
- Event-driven simulation
- Network routing protocols
- Medical emergency systems

---

## Priority Queue Implementation in Java
*[30 minutes]*

### Java's PriorityQueue Class
Java provides the `PriorityQueue` class in the `java.util` package:

```java
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Creates a min-priority queue by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add elements
        pq.add(30);
        pq.add(10);
        pq.add(20);
        
        System.out.println("Priority Queue: " + pq);  // Note: may not print in priority order
        
        // Peek at the highest priority element (lowest value in min-priority queue)
        System.out.println("Highest priority element: " + pq.peek());  // 10
        
        // Remove highest priority elements one by one
        while (!pq.isEmpty()) {
            System.out.println("Removing: " + pq.poll());
        }
        // Output: 10, 20, 30
    }
}
```

### Creating a Max-Priority Queue
```java
// Using a custom comparator for a max-priority queue
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
maxPQ.add(10);
maxPQ.add(30);
maxPQ.add(20);

System.out.println("Max element: " + maxPQ.peek());  // 30
```

### Using Priority Queue with Custom Objects

```java
import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    private String name;
    private int emergencyLevel;  // 1-10, with 10 being most severe
    
    public Patient(String name, int emergencyLevel) {
        this.name = name;
        this.emergencyLevel = emergencyLevel;
    }
    
    public String getName() {
        return name;
    }
    
    public int getEmergencyLevel() {
        return emergencyLevel;
    }
    
    @Override
    public int compareTo(Patient other) {
        // Higher emergency level has higher priority (comes first)
        return other.emergencyLevel - this.emergencyLevel;
    }
    
    @Override
    public String toString() {
        return name + " (Level: " + emergencyLevel + ")";
    }
}

public class HospitalEmergencyRoom {
    public static void main(String[] args) {
        PriorityQueue<Patient> emergencyQueue = new PriorityQueue<>();
        
        emergencyQueue.add(new Patient("Smith", 3));
        emergencyQueue.add(new Patient("Johnson", 8));
        emergencyQueue.add(new Patient("Williams", 5));
        emergencyQueue.add(new Patient("Jones", 10));
        
        System.out.println("Emergency Room Queue:");
        
        // Process patients by priority
        while (!emergencyQueue.isEmpty()) {
            Patient patient = emergencyQueue.poll();
            System.out.println("Now treating: " + patient);
        }
    }
}
```

### Alternative Using Comparator

```java
import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    private String description;
    private int priority;  // 1-5, with 5 being highest priority
    
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPriority() {
        return priority;
    }
    
    @Override
    public String toString() {
        return description + " (Priority: " + priority + ")";
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        // Using a Comparator to define priority
        Comparator<Task> priorityComparator = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t2.getPriority() - t1.getPriority();
            }
        };
        
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(priorityComparator);
        
        // Or with lambda expression
        // PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t2.getPriority() - t1.getPriority());
        
        taskQueue.add(new Task("Send email", 2));
        taskQueue.add(new Task("Fix critical bug", 5));
        taskQueue.add(new Task("Update documentation", 1));
        taskQueue.add(new Task("Prepare presentation", 3));
        
        System.out.println("Tasks in priority order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
```

---

## Heap Data Structure
*[20 minutes]*

### What is a Heap?
A heap is a specialized tree-based data structure that satisfies the heap property:
- In a max heap, for any given node, the value is greater than or equal to the values of its children
- In a min heap, for any given node, the value is less than or equal to the values of its children

### Properties of a Binary Heap
- Complete binary tree (all levels filled except possibly the last level, which is filled from left to right)
- Heap property (max or min) is maintained for all nodes
- Efficient for finding the minimum or maximum element
- Typically implemented using arrays, not linked nodes

### Array Representation of Heap
For a zero-based array:
- Parent of node at index i: (i-1)/2
- Left child of node at index i: 2*i + 1
- Right child of node at index i: 2*i + 2

### Key Heap Operations
- **insert**: Add a new element while maintaining the heap property (O(log n))
- **extractMin/extractMax**: Remove and return the root element (O(log n))
- **peek**: View the root element without removing it (O(1))
- **heapify**: Convert an arbitrary array into a valid heap (O(n))

### Heap Sort
- Create a heap from the input array
- Repeatedly extract the root to get elements in sorted order
- Time complexity: O(n log n)

### Visual Example of a Min Heap

```
       10         Level 0
     /    \
   15      30     Level 1
  /  \    /
 40  50  100      Level 2
```

Array representation: [10, 15, 30, 40, 50, 100]

### PriorityQueue Implementation
Java's `PriorityQueue` is typically implemented using a binary heap data structure.

---

## Priority Queue Applications
*[15 minutes]*

### Detailed Applications

1. **Dijkstra's Algorithm**
   - Finding shortest paths in graphs
   - Uses a priority queue to select vertices with minimum distance

```java
void dijkstra(Graph graph, int source) {
    PriorityQueue<Node> pq = new PriorityQueue<>(
        (n1, n2) -> n1.distance - n2.distance);
    
    // Initialize distances
    int[] distance = new int[graph.V];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;
    
    pq.add(new Node(source, 0));
    
    while (!pq.isEmpty()) {
        Node node = pq.poll();
        int u = node.vertex;
        
        // For each adjacent vertex
        for (Edge edge : graph.adj[u]) {
            int v = edge.dest;
            int weight = edge.weight;
            
            if (distance[u] + weight < distance[v]) {
                distance[v] = distance[u] + weight;
                pq.add(new Node(v, distance[v]));
            }
        }
    }
}
```

2. **CPU Scheduling**
   - Priority-based process scheduling in operating systems
   - Higher priority processes execute before lower priority ones

3. **Huffman Coding**
   - Data compression algorithm
   - Uses a priority queue to build an optimal prefix tree

4. **Event-Driven Simulation**
   - Discrete event simulators process events by priority order
   - Time-based simulations use timestamps as priorities

5. **A* Search Algorithm**
   - Pathfinding algorithm used in artificial intelligence
   - Uses a priority queue to select paths with lowest estimated cost

### Example: Job Scheduler
```java
class Job implements Comparable<Job> {
    private String name;
    private int priority;
    private long deadline;
    
    // Constructor, getters, setters...
    
    @Override
    public int compareTo(Job other) {
        // First compare by priority (higher is better)
        if (this.priority != other.priority) {
            return other.priority - this.priority;
        }
        // If priority is the same, compare by deadline (earlier is better)
        return Long.compare(this.deadline, other.deadline);
    }
}

class JobScheduler {
    private PriorityQueue<Job> jobQueue = new PriorityQueue<>();
    
    public void addJob(Job job) {
        jobQueue.add(job);
    }
    
    public Job getNextJob() {
        return jobQueue.poll();
    }
    
    // Other methods...
}
```

---

## Performance Considerations
*[15 minutes]*

### Time Complexity Comparison

| Operation | Array-based Queue | LinkedList Queue | Priority Queue (Heap) |
|-----------|------------------|-----------------|----------------------|
| Enqueue/Insert | O(1) amortized | O(1) | O(log n) |
| Dequeue/DeleteMin | O(1) | O(1) | O(log n) |
| Peek | O(1) | O(1) | O(1) |
| Search | O(n) | O(n) | O(n) |
| isEmpty | O(1) | O(1) | O(1) |
| Size | O(1) | O(1) or O(n)* | O(1) |

*Depends on implementation

### Space Complexity
- Array-based Queue: O(n) with fixed capacity
- LinkedList Queue: O(n) with dynamic resizing
- Priority Queue (Heap): O(n)

### Implementation Trade-offs

1. **Array-based Queue**
   - Pros: Cache-friendly, fixed memory allocation
   - Cons: Fixed capacity unless resizing, potential wasted space

2. **LinkedList Queue**
   - Pros: Dynamic size, efficient insertions/deletions
   - Cons: Extra memory for pointers, not cache-friendly

3. **Priority Queue (Heap)**
   - Pros: Efficient priority-based operations
   - Cons: More complex implementation, slightly slower than simple queue for basic operations

### Performance Tips
- Choose the right implementation based on your specific use case
- Consider thread safety needs (e.g., ConcurrentLinkedQueue for concurrency)
- For large datasets, priority queues may benefit from custom tuning
- Monitor memory usage in array-based implementations

---

## Practical Examples
*[25 minutes]*

### Example 1: Print Queue
```java
import java.util.LinkedList;
import java.util.Queue;

class PrintJob {
    private String document;
    private String user;
    
    public PrintJob(String document, String user) {
        this.document = document;
        this.user = user;
    }
    
    public String getDocument() {
        return document;
    }
    
    public String getUser() {
        return user;
    }
    
    @Override
    public String toString() {
        return "PrintJob{document='" + document + "', user='" + user + "'}";
    }
}

public class PrinterQueue {
    private Queue<PrintJob> jobQueue = new LinkedList<>();
    
    public void addJob(PrintJob job) {
        jobQueue.add(job);
        System.out.println("Added to print queue: " + job);
    }
    
    public void processJobs() {
        while (!jobQueue.isEmpty()) {
            PrintJob job = jobQueue.poll();
            System.out.println("Printing: " + job.getDocument() + 
                               " for user " + job.getUser());
            // Simulate printing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished printing: " + job.getDocument());
        }
    }
    
    public int getQueueSize() {
        return jobQueue.size();
    }
    
    public static void main(String[] args) {
        PrinterQueue printer = new PrinterQueue();
        
        printer.addJob(new PrintJob("Report.pdf", "Alice"));
        printer.addJob(new PrintJob("Letter.doc", "Bob"));
        printer.addJob(new PrintJob("Presentation.ppt", "Charlie"));
        
        System.out.println("Queue size: " + printer.getQueueSize());
        
        printer.processJobs();
        
        System.out.println("All jobs completed. Queue size: " + printer.getQueueSize());
    }
}
```

### Example 2: Customer Service System with Priority
```java
import java.util.PriorityQueue;

class ServiceTicket implements Comparable<ServiceTicket> {
    private int ticketNumber;
    private String customerName;
    private int priority;  // 1=low, 2=medium, 3=high
    private String issue;
    
    public ServiceTicket(int ticketNumber, String customerName, 
                         int priority, String issue) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.priority = priority;
        this.issue = issue;
    }
    
    // Getters
    public int getTicketNumber() { return ticketNumber; }
    public String getCustomerName() { return customerName; }
    public int getPriority() { return priority; }
    public String getIssue() { return issue; }
    
    @Override
    public int compareTo(ServiceTicket other) {
        // Compare by priority first (higher priority comes first)
        if (this.priority != other.priority) {
            return other.priority - this.priority;
        }
        // If priority is the same, use ticket number (first come first served)
        return this.ticketNumber - other.ticketNumber;
    }
    
    @Override
    public String toString() {
        String priorityStr;
        switch (priority) {
            case 1: priorityStr = "Low"; break;
            case 2: priorityStr = "Medium"; break;
            case 3: priorityStr = "High"; break;
            default: priorityStr = "Unknown";
        }
        
        return "Ticket #" + ticketNumber + " - " + customerName + 
               " (Priority: " + priorityStr + ") - Issue: " + issue;
    }
}

public class CustomerServiceSystem {
    private PriorityQueue<ServiceTicket> ticketQueue = new PriorityQueue<>();
    private int nextTicketNumber = 1;
    
    public void createTicket(String customerName, int priority, String issue) {
        ServiceTicket ticket = new ServiceTicket(
            nextTicketNumber++, customerName, priority, issue);
        ticketQueue.add(ticket);
        System.out.println("Created: " + ticket);
    }
    
    public void processNextTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
            return;
        }
        
        ServiceTicket ticket = ticketQueue.poll();
        System.out.println("Now processing: " + ticket);
        
        // Simulate ticket resolution
        System.out.println("Resolved issue for " + ticket.getCustomerName());
    }
    
    public void showTicketQueue() {
        if (ticketQueue.isEmpty()) {
            System.out.println("The ticket queue is empty.");
            return;
        }
        
        System.out.println("Current ticket queue (in priority order):");
        
        // Copy tickets to avoid modifying the original queue
        PriorityQueue<ServiceTicket> tempQueue = new PriorityQueue<>(ticketQueue);
        while (!tempQueue.isEmpty()) {
            System.out.println("  " + tempQueue.poll());
        }
    }
    
    public int getQueueSize() {
        return ticketQueue.size();
    }
    
    public static void main(String[] args) {
        CustomerServiceSystem helpdesk = new CustomerServiceSystem();
        
        helpdesk.createTicket("John Smith", 1, "Can't access email");
        helpdesk.createTicket("Sarah Johnson", 3, "Server down");
        helpdesk.createTicket("Mike Brown", 2, "Password reset");
        helpdesk.createTicket("Lisa Davis", 3, "Network outage");
        
        System.out.println("\nQueue size: " + helpdesk.getQueueSize());
        
        helpdesk.showTicketQueue();
        
        System.out.println("\nProcessing tickets:");
        helpdesk.processNextTicket();
        helpdesk.processNextTicket();
        
        System.out.println("\nRemaining tickets:");
        helpdesk.showTicketQueue();
    }
}
```

---

## Common Errors and Debugging
*[15 minutes]*

### Common Queue-Related Errors

1. **Queue Underflow**
   - Attempting to dequeue from an empty queue
   - Solution: Always check if the queue is empty before dequeuing

```java
if (!queue.isEmpty()) {
    Object item = queue.poll();
    // Process item
} else {
    // Handle empty queue
}
```

2. **Circular Queue Implementation Errors**
   - Incorrect front/rear pointer management
   - Off-by-one errors when calculating indices
   - Solution: Carefully manage indices and use modulo arithmetic

3. **Confusion Between Queue Methods**
   - `add()` vs. `offer()`, `remove()` vs. `poll()`
   - Solution: Choose methods based on whether you want exceptions or special return values

4. **Comparing Custom Objects in Priority Queues**
   - Inconsistent `compareTo()` implementation
   - Not handling equality cases properly
   - Solution: Ensure proper implementation of `Comparable` or `Comparator`

```java
// Bad implementation - doesn't handle equality consistently
@Override
public int compareTo(Task other) {
    // This could lead to inconsistent behavior
    if (this.priority > other.priority) return 1;
    if (this.priority < other.priority) return -1;
    return 0;
}

// Better implementation
@Override
public int compareTo(Task other) {
    return Integer.compare(this.priority, other.priority);
}
```

5. **Memory Leaks in Custom Queue Implementations**
   - Not nulling references to dequeued objects
   - Solution: Set array elements to null after dequeuing

```java
public E dequeue() {
    if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
    }
    E element = elements[front];
    elements[front] = null;  // Avoid memory leak
    front = (front + 1) % elements.length;
    size--;
    return element;
}
```

6. **Printing Queue Contents Incorrectly**
   - Direct printing of a priority queue doesn't show priority order
   - Solution: Dequeue elements one by one to see actual processing order

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(3);
pq.add(1);
pq.add(2);

// This doesn't necessarily print in priority order
System.out.println(pq);  // May not print [1, 3, 2] in order

// This shows the actual priority order
while (!pq.isEmpty()) {
    System.out.print(pq.poll() + " ");  // Prints "1 2 3"
}
```

7. **Infinite Loops in Custom Queue Implementations**
   - Incorrect termination conditions
   - Not updating counters properly
   - Solution: Carefully review loop conditions and variable updates

### Debugging Tips
- Use assertions to verify queue state at critical points
- Implement toString() method for better debugging outputs
- Use visualization tools to understand heap structure
- Add logging for queue operations during development

---

## Practice Problems
*[20 minutes]*

### Problem 1: Queue Implementation
Implement a simple queue supporting the following operations:
- enqueue(item): Add an item to the queue
- dequeue(): Remove and return the front item
- peek(): Return the front item without removing it
- isEmpty(): Return true if the queue is empty
- size(): Return the number of items in the queue

### Problem 2: Hot Potato Game
Implement the Hot Potato game simulation:
- N children stand in a circle
- A potato is passed around
- After M passes, the child holding the potato is eliminated
- Continue until only one child remains

```java
import java.util.LinkedList;
import java.util.Queue;

public class HotPotato {
    public static String playGame(String[] players, int passes) {
        Queue<String> circle = new LinkedList<>();
        
        // Add all players to the queue
        for (String player : players) {
            circle.add(player);
        }
        
        // Play until only one player remains
        while (circle.size() > 1) {
            // Pass the potato
            for (int i = 0; i < passes; i++) {
                // Move the front player to the rear
                String player = circle.poll();
                circle.add(player);
            }
            
            //