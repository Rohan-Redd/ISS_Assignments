package library;

//Abstract class representing a generic library item
abstract class LibraryItem implements Borrowable {
 private String title;

 public LibraryItem(String title) {
     this.title = title;
 }

 // Abstract method for displaying item details
 public abstract void displayDetails();

 // Getter method for the title
 public String getTitle() {
     return title;
 }
}