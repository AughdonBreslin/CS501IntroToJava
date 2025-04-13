package Queues_16;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
import java.util.PriorityQueue;
import java.util.Comparator;

class PrioProcess {
    private String id;
    private int priority;       // Lower number means higher priority
    private int arrivalTime;    // When the process arrives in the system
    private int burstTime;      // CPU time needed to complete
    private int remainingTime;  // Remaining execution time

    public PrioProcess(String id, int priority, int arrivalTime, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void executeForOneUnit() {
        if (remainingTime > 0) {
            remainingTime--;
        }
    }

    public boolean isCompleted() {
        return remainingTime <= 0;
    }

    @Override
    public String toString() {
        return "Process{" + "id='" + id + "', priority=" + priority +
                ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime +
                ", remainingTime=" + remainingTime + '}';
    }
}

class PriorityScheduler {
    private PriorityQueue<PrioProcess> readyQueue;
    private PrioProcess currentProcess;
    private int currentTime;
    private int totalProcesses;
    private int completedProcesses;

    // Statistics
    private int[] waitingTime;
    private int[] turnaroundTime;
    private int[] responseTime;

    public PriorityScheduler(int capacity) {
        // Create priority queue with custom comparator for processes
        // Lower priority number means higher priority
        readyQueue = new PriorityQueue<>(Comparator.comparingInt(PrioProcess::getPriority));
        currentTime = 0;
        totalProcesses = capacity;
        completedProcesses = 0;
        waitingTime = new int[capacity];
        turnaroundTime = new int[capacity];
        responseTime = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            waitingTime[i] = -1;
            responseTime[i] = -1;
        }
    }

    public void addProcess(PrioProcess process) {
        if (process.getArrivalTime() <= currentTime) {
            readyQueue.add(process);
        } else {
            // Store process for later arrival
            System.out.println("Process " + process.getId() + " will arrive at time " + process.getArrivalTime());
        }
    }

    public void checkForNewArrivals(PrioProcess[] processes) {
        for (PrioProcess p : processes) {
            if (p.getArrivalTime() == currentTime && !readyQueue.contains(p) && !p.isCompleted()) {
                System.out.println("Time " + currentTime + ": Process " + p.getId() + " arrived");
                readyQueue.add(p);
            }
        }
    }

    public void run(PrioProcess[] processes) {
        System.out.println("Starting Priority Scheduler");

        // Initialize with processes that arrive at time 0
        for (PrioProcess p : processes) {
            if (p.getArrivalTime() == 0) {
                readyQueue.add(p);
            }
        }

        while (completedProcesses < totalProcesses) {
            // Check for newly arrived processes
            checkForNewArrivals(processes);

            // Check if a higher priority process has arrived
            if (!readyQueue.isEmpty()) {
                PrioProcess highestPrioProcess = readyQueue.peek();
                if (currentProcess == null ||
                        highestPrioProcess.getPriority() < currentProcess.getPriority()) {

                    // Preempt current process if needed
                    if (currentProcess != null) {
                        readyQueue.add(currentProcess);
                        System.out.println("Time " + currentTime + ": Process " + currentProcess.getId() +
                                " preempted by higher priority process");
                    }

                    currentProcess = readyQueue.poll();
                    int processIndex = Integer.parseInt(currentProcess.getId().substring(1)) - 1;

                    // Record response time (first time the process gets CPU)
                    if (responseTime[processIndex] == -1) {
                        responseTime[processIndex] = currentTime - currentProcess.getArrivalTime();
                    }

                    System.out.println("Time " + currentTime + ": Process " + currentProcess.getId() +
                            " (Priority: " + currentProcess.getPriority() + ") started execution");
                }
            }

            // Execute current process for one time unit
            if (currentProcess != null) {
                currentProcess.executeForOneUnit();

                // Check if process completed
                if (currentProcess.isCompleted()) {
                    int processIndex = Integer.parseInt(currentProcess.getId().substring(1)) - 1;

                    turnaroundTime[processIndex] = (currentTime + 1) - currentProcess.getArrivalTime();
                    waitingTime[processIndex] = turnaroundTime[processIndex] - currentProcess.getBurstTime();

                    System.out.println("Time " + (currentTime + 1) + ": Process " + currentProcess.getId() +
                            " completed. Turnaround time: " + turnaroundTime[processIndex] +
                            ", Waiting time: " + waitingTime[processIndex]);

                    completedProcesses++;
                    currentProcess = null;
                }
            }

            currentTime++;

            if (currentProcess == null && readyQueue.isEmpty() && completedProcesses < totalProcesses) {
                System.out.println("Time " + currentTime + ": CPU idle, waiting for next process");
            }
        }

        printStatistics();
    }

    private void printStatistics() {
        System.out.println("\n======= SCHEDULING STATISTICS =======");

        double avgWaiting = 0;
        double avgTurnaround = 0;
        double avgResponse = 0;

        for (int i = 0; i < totalProcesses; i++) {
            System.out.println("Process P" + (i+1) +
                    " - Waiting time: " + waitingTime[i] +
                    ", Turnaround time: " + turnaroundTime[i] +
                    ", Response time: " + responseTime[i]);

            avgWaiting += waitingTime[i];
            avgTurnaround += turnaroundTime[i];
            avgResponse += responseTime[i];
        }

        avgWaiting /= totalProcesses;
        avgTurnaround /= totalProcesses;
        avgResponse /= totalProcesses;

        System.out.println("\nAverage waiting time: " + avgWaiting);
        System.out.println("Average turnaround time: " + avgTurnaround);
        System.out.println("Average response time: " + avgResponse);
    }

    public static void main(String[] args) {
        // Create processes with format: id, priority, arrival time, burst time
        PrioProcess[] processes = {
                new PrioProcess("P1", 3, 0, 6),   // Process 1: priority 3, arrives at time 0, needs 6 time units
                new PrioProcess("P2", 1, 2, 4),   // Process 2: priority 1 (highest), arrives at time 2, needs 4 time units
                new PrioProcess("P3", 4, 4, 5),   // Process 3: priority 4, arrives at time 4, needs 5 time units
                new PrioProcess("P4", 2, 6, 3)    // Process 4: priority 2, arrives at time 6, needs 3 time units
        };

        PriorityScheduler scheduler = new PriorityScheduler(processes.length);
        scheduler.run(processes);
    }
}