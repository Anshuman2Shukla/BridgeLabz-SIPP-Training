import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

class Book {
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class Problem05_LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Fiction", 300),
            new Book("Book B", "Fiction", 250),
            new Book("Book C", "Science", 400),
            new Book("Book D", "Science", 500),
            new Book("Book E", "History", 350)
        );

        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println(genre + " -> " + stats);
        });
    }
}