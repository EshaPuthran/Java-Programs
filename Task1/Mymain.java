package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Interface for items that can be issued or returned
interface Issueable {
    void issue() throws ExceptionBookNotAvailable;
    void returnItem();
    boolean isAvailable();
}

//  exception for unavailable books
class ExceptionBookNotAvailable extends Exception {
    public ExceptionBookNotAvailable(String message) {
        super(message);
    }
}

// Abstract parent class_Inheritance demo
abstract class LibraryItem implements Issueable {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean available = true;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return title + " by " + author + " [ISBN: " + isbn + "] - "  + (available ? "Available" : "Issued");
    }
}

// Book extends LibraryItem (Inheritance)
class Book extends LibraryItem
{
    public Book(String title, String author, String isbn)
    {
        super(title, author, isbn);
    }

    @Override
    public void issue() throws ExceptionBookNotAvailable 
    {
        if (!available)
        {
            throw new ExceptionBookNotAvailable("Your Book '" + title + "' is already issued.");
        }
        available = false;
    }

    @Override
    public void returnItem()
    {
        if (available)
        {
            System.out.println("Your choosed Book  '" + title + "' is already in the library.");
        } 
        else 
        {
            available = true;
        }
    }
}

// Exception for when a book is not found
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

// Library class which manages the collection
class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book b) {
        if (books.containsKey(b.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + b.getIsbn());
        }
        books.put(b.getIsbn(), b);
    }

    public Book findBook(String isbn)
    {
        return books.get(isbn);
    }

    public void issueBook(String isbn) throws BookNotFoundException, ExceptionBookNotAvailable
    {
        Book b = books.get(isbn);
        if (b == null) throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        b.issue();
    }

    public void returnBook(String isbn) throws BookNotFoundException 
    {
        Book b = books.get(isbn);
        if (b == null) throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        b.returnItem();
    }

    public void showBooks()
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books in the library yet");
        } 
        else
        {
            for (Book b : books.values())
            {
                System.out.println(b);
            }
        }
    }
}

// Main class which takes keyboard input
public class Mymain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n Library Management Menu");
            System.out.println("1.To Add Book");
            System.out.println("2. To Issue a Book");
            System.out.println("3. To Return a Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("What task do you want to perform: ");
            int choice = sc.nextInt();
            sc.nextLine(); // for newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("What is the title of your book: ");
                        String title = sc.nextLine();
                        System.out.print("What is the name of the author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter the isusse book number: ");
                        String isbn = sc.nextLine();
                        lib.addBook(new Book(title, author, isbn));
                        System.out.println("Congratulation!! Your Book was added successfully");
                        break;

                    case 2:
                        System.out.print("Enter book number to be issued: ");
                        String issueIsbn = sc.nextLine();
                        lib.issueBook(issueIsbn);
                        System.out.println("Your Book was issued successfully!");
                        break;

                    case 3:
                        System.out.print("Could you mention the isusee book number of the book to be returned: ");
                        String returnIsbn = sc.nextLine();
                        lib.returnBook(returnIsbn);
                        System.out.println("Your Book is returned successfully!");
                        System.out.println("Thank You and Please do visit again");
                        break;

                    case 4:
                        lib.showBooks();
                        break;

                    case 5:
                        System.out.println("Thank You for visiting. Please do visit again ");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (BookNotFoundException |ExceptionBookNotAvailable | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

	
