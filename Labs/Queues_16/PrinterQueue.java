package Queues_16;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/6/2025, Sunday
 **/
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