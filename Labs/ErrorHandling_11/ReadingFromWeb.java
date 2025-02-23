package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/23/2025, Sunday
 **/
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class ReadingFromWeb {
    public static String read(String link) {
        StringBuilder output = new StringBuilder();
        try {
            URL url = new URL(link);
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext()) {
                output.append(scan.nextLine()).append("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(read("https://github.com/AughdonBreslin"));
    }
}
