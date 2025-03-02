package AbstractClassesAndInterfaces_12;

import java.util.Arrays;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/

// Comparable uses a Generic, we will discuss this later
class Book implements Comparable<Book> {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return title;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        Book[] books = {
                new Book("The Great Gatsby"),
                new Book("To Kill a Mockingbird"),
                new Book("1984"),
                new Book("Moby-Dick"),
                new Book("War and Peace"),
                new Book("Pride and Prejudice"),
                new Book("The Catcher in the Rye"),
                new Book("The Lord of the Rings"),
                new Book("Brave New World"),
                new Book("Fahrenheit 451"),
                new Book("Crime and Punishment"),
                new Book("Wuthering Heights"),
                new Book("The Odyssey"),
                new Book("The Hobbit"),
                new Book("One Hundred Years of Solitude")
        };

        Arrays.sort(books);

        for (Book book : books) {
            System.out.println(book);
        }


    }
}
