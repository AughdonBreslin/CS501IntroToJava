package Queues_16;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
import java.util.PriorityQueue;

class PrioritizedProcess implements Comparable<PrioritizedProcess> {
    private String id;
    private int priority;
    private int burstTime;

    public PrioritizedProcess(String id, int priority, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
    }

    public String getId() { return id; }
    public int getPriority() { return priority; }
    public int getBurstTime() { return burstTime; }

    @Override
    public int compareTo(PrioritizedProcess other) {
        // Lower number means higher priority
        return Integer.compare(this.priority, other.priority);
    }
}

public class BasicPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<PrioritizedProcess> queue = new PriorityQueue<>();

        queue.add(new PrioritizedProcess("P1", 3, 10));
        queue.add(new PrioritizedProcess("P2", 1, 5));  // Highest priority (lowest number)
        queue.add(new PrioritizedProcess("P3", 4, 3));
        queue.add(new PrioritizedProcess("P4", 2, 7));

        System.out.println("Processes execution order based on priority:");
        while (!queue.isEmpty()) {
            PrioritizedProcess p = queue.poll();
            System.out.println("Executing: " + p.getId() +
                    " (Priority: " + p.getPriority() +
                    ", Burst time: " + p.getBurstTime() + ")");
        }
    }
}