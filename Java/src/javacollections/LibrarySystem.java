package javacollections;
import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        // List of books
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        bookList.add(new Book("American Psycho", "Bret Easton Ellis"));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        bookList.add(new Book("Dune", "Frank Herbert"));
        bookList.add(new Book("Babylon", "F. Scott Fitzgerald"));
        bookList.add(new Book("Less than Zero", "Bret Easton Ellis"));

        // Set of authors
        Set<String> authorSet = new HashSet<>();
        for (Book book : bookList) {
            authorSet.add(book.getAuthor());
        }

        // Map of books with title as key
        Map<String, Book> bookMap = new HashMap<>();
        for (Book book : bookList) {
            bookMap.put(book.getTitle(), book);
        }

        // Displaying initial collections
        System.out.println("List of Books: " + bookList);
        System.out.println("Set of Authors: " + authorSet);
        System.out.println("Map of Books: " + bookMap);
        
        // Sorting the list of books using Comparable (based on title)
        Collections.sort(bookList);
        System.out.println("\nList of Books (Sorted by Title): " + bookList);

        // Sorting the list of books using Comparator (based on author)
        Collections.sort(bookList, Comparator.comparing(Book::getAuthor));
        System.out.println("List of Books (Sorted by Author): " + bookList);

        // Performing collection operations on primitive data types (Counting books per author)
        Map<String, Integer> booksPerAuthor = new HashMap<>();

        for (Book book : bookList) {
            String author = book.getAuthor();
            // Increment the count for each book by the author
            booksPerAuthor.put(author, booksPerAuthor.getOrDefault(author, 0) + 1);
        }

        System.out.println("\nNumber of Books Per Author: " + booksPerAuthor);
    }
}