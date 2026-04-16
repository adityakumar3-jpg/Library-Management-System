class Book {

    String title;
    String author;
    boolean isAvailable;

    Book(String t, String a) {
        title = t;
        author = a;
        isAvailable = true;
    }
}


class Library {

    Book[] books = new Book[3];

    Library() {
        books[0] = new Book("Java Basics", "James Gosling");
        books[1] = new Book("Data Structures", "Mark Allen");
        books[2] = new Book("Operating Systems", "Silberschatz");
    }

    void displayBooks() {
        System.out.println("All Books:");
        for (int i = 0; i < 3; i++) {
            if (books[i].isAvailable == true) {
                System.out.println(books[i].title + " - Available");
            } else {
                System.out.println(books[i].title + " - Issued");
            }
        }
    }

    void issueBook(String name) {
        for (int i = 0; i < 3; i++) {
            if (books[i].title == name) {
                if (books[i].isAvailable == true) {
                    books[i].isAvailable = false;
                    System.out.println(name + " issued successfully");
                } else {
                    System.out.println(name + " is already issued");
                }
            }
        }
    }

    void returnBook(String name) {
        for (int i = 0; i < 3; i++) {
            if (books[i].title == name) {
                books[i].isAvailable = true;
                System.out.println(name + " returned successfully");
            }
        }
    }
}


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
