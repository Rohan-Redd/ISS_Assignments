package library;

//Class representing a Book, inheriting from LibraryItem
class Book extends LibraryItem {
 private String author;

 public Book(String title, String author) {
     super(title);
     this.author = author;
 }

 // Implementation of displayDetails method
 @Override
 public void displayDetails() {
     System.out.println("Book Title: " + getTitle());
     System.out.println("Author: " + author);
 }

 // Implementation of Borrowable interface methods
 @Override
 public void borrowItem() {
     System.out.println("Book \"" + getTitle() + "\" has been borrowed.");
 }

 @Override
 public void returnItem() {
     System.out.println("Book \"" + getTitle() + "\" has been returned.");
 }
}
