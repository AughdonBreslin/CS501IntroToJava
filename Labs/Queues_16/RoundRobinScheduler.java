package Queues_16;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
import java.util.LinkedList;
import java.util.Queue;

class Process {
    private String id;
    private int burstTime; // time required to complete the process
    private int remainingTime; // time remaining to complete the process

    public Process(String id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    public String getId() {
        return id;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void executeForTimeSlice(int timeSlice) {
        int executionTime = Math.min(timeSlice, remainingTime);
        remainingTime -= executionTime;
        System.out.println("Process " + id + " executed for " + executionTime + " time units. Remaining: " + remainingTime);
    }

    public boolean isCompleted() {
        return remainingTime <= 0;
    }

    @Override
    public String toString() {
        return "Process(ID: " + id + ", Burst Time: " + burstTime + ", Remaining Time: " + remainingTime + ")";
    }
}

public class RoundRobinScheduler {
    private Queue<Process> readyQueue;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.readyQueue = new LinkedList<>();
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(Process process) {
        readyQueue.add(process);
    }

    public void run() {
        System.out.println("Starting Round Robin scheduling with time quantum: " + timeQuantum);
        int currentTime = 0;

        while (!readyQueue.isEmpty()) {
            Process currentProcess = readyQueue.poll();

            // Execute the process for one time quantum
            System.out.println("\nAt time " + currentTime + ", executing process " + currentProcess.getId());
            currentProcess.executeForTimeSlice(timeQuantum);
            currentTime += Math.min(timeQuantum, currentProcess.getRemainingTime() + timeQuantum);

            // If the process is not completed, put it back in the queue
            if (!currentProcess.isCompleted()) {
                readyQueue.add(currentProcess);
            } else {
                System.out.println("Process " + currentProcess.getId() + " completed execution.");
            }
        }

        System.out.println("\nAll processes completed. Total time: " + currentTime);
    }

    public static void main(String[] args) {
        // Create a scheduler with time quantum of 2
        RoundRobinScheduler scheduler = new RoundRobinScheduler(2);

        // Add some processes with their burst times
        scheduler.addProcess(new Process("P1", 6));
        scheduler.addProcess(new Process("P2", 4));
        scheduler.addProcess(new Process("P3", 8));

        // Run the scheduler
        scheduler.run();
    }
}
