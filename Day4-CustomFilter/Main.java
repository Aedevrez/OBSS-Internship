import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Isles of Emberdark", "Brando S.", 2025, 40, "Fantasy"));
        books.add(new Book("Time Machine", "Stephan Z.", 1895, 20, "Science Fiction"));

        FilterBasedOnGenre filter2 = (book) -> book.getGenre().equals("Science Fiction");

        System.out.println("\nBooks that are sci fi");
        for (Book bookInQuestion : books) {
            if (filter2.isScienceFiction(bookInQuestion)) {
                System.out.println(bookInQuestion);
            }
        }

        FilterBasedOnYear filter = (book, year) -> book.getPublicationYear() > year;

        System.out.println("\nBooks newer than 2020");
        for (Book bookInQuestion : books) {
            if (filter.greaterThanYear(bookInQuestion, 2020)) {
                System.out.println(bookInQuestion);
            }
        }
    }

}
