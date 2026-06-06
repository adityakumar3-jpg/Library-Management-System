// Abstract Parent class (Abstraction)
abstract class Item {
    private String title;
    private boolean isAvailable;

    public Item(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    // Encapsulation (getters & setters)
    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    // Abstract method (must be implemented by child)
    abstract void displayDetails();
}


// Child class (Inheritance + Abstraction implementation)
class Book extends Item {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // Implementing abstract method
    void displayDetails() {
        if (isAvailable()) {
            System.out.println(getTitle() + " by " + author + " - Available");
        } else {
            System.out.println(getTitle() + " by " + author + " - Issued");
        }
    }
}


// Library class
class Library {

    private Book[] books = new Book[3];

    public Library() {
        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Allen");
        books[2] = new Book("Operating Systems", "Silberschatz");
    }

    public void displayBooks() {
        System.out.println("All Books:");
        for (int i = 0; i < books.length; i++) {
            books[i].displayDetails(); // using abstraction
        }
    }

    public void issueBook(String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(name)) {
                if (books[i].isAvailable()) {
                    books[i].setAvailable(false);
                    System.out.println(name + " issued successfully");
                } else {
                    System.out.println(name + " is already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void returnBook(String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(name)) {
                books[i].setAvailable(true);
                System.out.println(name + " returned successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }
}


// Main class
public class Main {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.displayBooks();

        lib.issueBook("Java Basics");
        lib.issueBook("Java Basics");

        lib.displayBooks();

        lib.returnBook("Java Basics");

        lib.displayBooks();
    }
}
