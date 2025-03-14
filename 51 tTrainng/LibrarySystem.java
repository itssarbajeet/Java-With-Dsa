import java.util.*;
class Library {
    private Map<String, Integer> books;

    public Library() {
        books = new HashMap<>();
        books.put("Book1", 1);
        books.put("Book2", 2);
        books.put("Book3", 1);
    }

    public void borrowBook(String bookName) {
        Integer availableCopies = books.get(bookName);
        if (availableCopies != null && availableCopies > 0) {
            System.out.println(Thread.currentThread().getName() + " borrowed " + bookName);
            books.put(bookName, availableCopies - 1);
        } else {
            System.out.println(Thread.currentThread().getName() + " could not borrow " + bookName + " (not available)");
        }
    }
}

class Reader implements Runnable {
    private Library library;
    private String bookName;

    public Reader(Library library, String bookName) {
        this.library = library;
        this.bookName = bookName;
    }

    @Override
    public void run() {
        library.borrowBook(bookName);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        Thread reader1 = new Thread(new Reader(library, "Book1"), "Reader1");
        Thread reader2 = new Thread(new Reader(library, "Book1"), "Reader2");
        Thread reader3 = new Thread(new Reader(library, "Book2"), "Reader3");
        Thread reader4 = new Thread(new Reader(library, "Book3"), "Reader4");
        Thread reader5 = new Thread(new Reader(library, "Book3"), "Reader5");

        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
    }
}