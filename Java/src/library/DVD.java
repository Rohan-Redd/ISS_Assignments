package library;

//Class representing a DVD, inheriting from LibraryItem
class DVD extends LibraryItem {
 private String director;

 public DVD(String title, String director) {
     super(title);
     this.director = director;
 }

 // Implementation of displayDetails method
 @Override
 public void displayDetails() {
     System.out.println("DVD Title: " + getTitle());
     System.out.println("Director: " + director);
 }

 // Implementation of Borrowable interface methods
 @Override
 public void borrowItem() {
     System.out.println("DVD \"" + getTitle() + "\" has been borrowed.");
 }

 @Override
 public void returnItem() {
     System.out.println("DVD \"" + getTitle() + "\" has been returned.");
 }
}