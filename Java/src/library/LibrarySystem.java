// Java concepts like inheritance, overriding, polymorphism, encapsulation and interfaces have been implemented.

package library;

//Main class
public class LibrarySystem {
 public static void main(String[] args) {
     // Creating instances of Book and DVD
     Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien");
     DVD dvd = new DVD("Oppenheimer", "Christopher Nolan");

     // Displaying item details
     book.displayDetails();
     System.out.println();
     dvd.displayDetails();

     // Borrowing and returning items
     book.borrowItem();
     dvd.borrowItem();
     book.returnItem();
     dvd.returnItem();
 }
}