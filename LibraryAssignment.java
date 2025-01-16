import java.util.*;

// Interface for Welcome Message
interface Welcome {
    void enter(String message);
}

// Welcome Implementation
class Come implements Welcome {
    @Override
    public void enter(String message) {
        System.out.println(message + "\n" + "Thanks for using this Library Management Application.");
    }
}

// Book Class
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        if (id == null || id.isEmpty() || title == null || title.isEmpty() || author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book details cannot be empty.");
        }
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (!isAvailable) {
            throw new IllegalStateException("Book is already borrowed.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        if (isAvailable) {
            throw new IllegalStateException("Book was not borrowed.");
        }
        isAvailable = true;
    }
}

// Library Management System
class Library {
    private List<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        for (Book b : bookList) {
            if (b.getId().equals(book.getId())) {
                throw new IllegalArgumentException("Book ID must be unique.");
            }
        }
        bookList.add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void borrowBook(String id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                if (!book.isAvailable()) {
                    throw new IllegalStateException("Book is not available for borrowing.");
                }
                book.borrow();
                System.out.println("Book borrowed: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        throw new NoSuchElementException("Book with ID " + id + " does not exist.");
    }

    public void returnBook(String id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                if (book.isAvailable()) {
                    throw new IllegalStateException("Book was not borrowed.");
                }
                book.returnBook();
                System.out.println("Book returned: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        throw new NoSuchElementException("Book with ID " + id + " does not exist.");
    }

    public void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : bookList) {
            if (book.isAvailable()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }
}

// Main Class
public class LibraryAssignment {
    public static void main(String[] args) {
        Come welcome = new Come();
        welcome.enter("Welcome to the Library Management System");

        Library library = new Library();

        try {
            library.addBook(new Book("101", "Java", "Joseph Hooks"));
            library.addBook(new Book("102", "C++", "Rocky"));
            library.addBook(new Book("103", "Python", "The Hoch"));
            library.addBook(new Book("104", "JavaScript", "Johnny Jooks"));

            library.viewAvailableBooks();

            library.borrowBook("101");
            library.viewAvailableBooks();

            library.returnBook("101");
            library.viewAvailableBooks();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

