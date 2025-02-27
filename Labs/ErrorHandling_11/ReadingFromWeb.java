package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/23/2025, Sunday
 **/
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ReadingFromWeb {
    public static String read(String link) {
        StringBuilder output = new StringBuilder();
        try {
            URL url = new URL(link); // break
            Scanner scan = new Scanner(url.openStream()); // skip all lines below
            while (scan.hasNext()) {
                output.append(scan.nextLine()).append("\n");
            }
        } catch (IOException e) { // catch the break
            System.err.println(e.getMessage());
        }
        // end of function, and i havent returned a string yet
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(read("https://www.cnn.com/"));
    }
}
