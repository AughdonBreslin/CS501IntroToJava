package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/23/2025, Sunday
 **/
import java.io.*;

public class FileHandling {
    public static String read(String filePath, int lines) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while(count < lines && (line = reader.readLine()) != null) {
                sb.append(line).append("\n");
                count++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return sb.toString();
    }

    public static void write(String filePath, String contents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(contents);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println("Does it exist? " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("How many bytes? " + file.length());
        System.out.println("Can it be read from? " + file.canRead());
        System.out.println("Can it be written to? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());

        String output = read(args[0], 100);
        System.out.println(output);

        write(args[0], "Hello my name is Bill\nand I love Java.");

        output = read(args[0], 100);
        System.out.println(output);
    }
}
