import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    Category[] categories = {
            new Category("Fiction", "fiction"),
            new Category("Action", "action"),
            new Category("Thriller", "thriller"),
            new Category("Comedy", "comedy"),
            new Category("Non-Fiction", "Non-Fiction"),
            new Category("Mystery", "Mystery"),
            new Category("Self-Help", "Self-Help"),
            new Category("Memoir", "Memoir"),
            new Category("Science Fiction", "Science Fiction")
    };
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Patron> patrons = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    public Library() {
    }

    public void displayCategories() {
        // display name of categories
        System.out.println("List of the categories");
        for (Category c : categories) {
            System.out.println(c.name);
        }
    }

    public void addBook(String bookTitle, String bookAuthor, String bookIdentifier, boolean isAvailable,
            String categoryname) {
                // add book to library
        Category category = getCategory(categoryname);
        Book book;
        if (category == null) {
            System.out.println("Category not found, Entering into default category");
            book = new Book(bookTitle, bookAuthor, bookIdentifier, isAvailable);

        } else {


            book = new Book(bookTitle, bookAuthor, bookIdentifier, isAvailable, category);

        }
        books.add(book);
    }

    public void createPatron(String name, int id, String type) {
        // add patron to library
        Patron patron = new Patron(name, id, type);
        patrons.add(patron);
    }

    public boolean createLoan(int patronId, String title) {
        // create loan for patron
        Patron patron = getPatron(patronId);

        if (patron == null) {
            System.out.println("Invalid Patron Id");
            return false;
        }

        Book book = getBook(title);

        if (book == null) {
            System.out.println("Invalid book title");
            return false;
        }

        Loan loan = new Loan();

        boolean isBorrowed = loan.createLoan(book, patron);

        if(!isBorrowed){
            System.out.println("Book has been borrowed");
            return false;
        }
        loans.add(loan);
        return true;
    }

    public boolean returnBook(int patronId, String title) {
        // return book to library
        Patron patron = getPatron(patronId);

        if (patron == null) {
            System.out.println("Invalid Patron Id");
            return false;
        }    

        Book book = getBook(title); 

        if (book == null) {
            System.out.println("Invalid book title");
            return false;
        }       

        for (Loan l : loans) {
            if (l.book.bookTitle.equals(book.bookTitle) && l.patron.id == patronId) {
                l.completeLoan();
                return true;
            }
        }
        System.out.println("Book hasnot been burrowed");
        return false;
    }

    public ArrayList<Loan> getLoans() {
        // display loans of patrons
        for (Loan l : loans) {
//            l.getLoanDetails();
            System.out.println(l);
        }

        return this.loans;
    }

    public Book getBook(String title) {
        // get book from library
        for (Book b : books) {
            if (b.bookTitle.equals(title)) {
                return b;
            }
        }

        return null;
    }

    public Patron getPatron(int patronId) {
        // get patron from library
        for (Patron p : patrons) {
            if (p.id == patronId) {
                return p;
            }
        }

        return null;
    }

    public ArrayList<Patron> getPatrons() {
        // display patrons 
        for (Patron p : patrons) {
            p.getPatronDetails();
        }

        return this.patrons;
    }

    public void getCategories() {
        // display categories
        for (Category c : categories) {
            c.getCategory();
        }
    }

    public ArrayList<Book> getBooks() {
        // display books
        return books;
    }

    public Category getCategory(String slug) {
        // get category from library
        for (Category category : categories) {
            if (category.slug.equalsIgnoreCase(slug)) {
                return category;
            }
        }

        return null;
    }

    public boolean removeBook(String title) {
        
        // remove book from library

        // check if book exists and available
        Book book = getBook(title);

        if (book == null) {
            System.out.println("Book not found");
            return false;
        }   

        if (!book.isAvailable) {
            System.out.println("Book is borrowed");
            return false;
        }

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).bookTitle.equals(title)) {
                books.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean removePatron(int id) {

        // check if patron exists
        boolean isPatron = false;

        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).id == id) {
                isPatron = true;
            }
        }   

        if(!isPatron){
            System.out.println("Patron not found");
            return false;
        }
        // chekk if patron has borrowed any book    
        boolean hasBorrowed = false;
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).patron.id == id) {
                if(loans.get(i).returnDate == null){
                    System.out.println("Patron has borrowed a book");
                    System.out.println(loans.get(i).book);
                    hasBorrowed = true;
                }
            }
        }

        if(hasBorrowed){
            return false;
        }
        // remove patron

        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).id == id) {
                patrons.remove(i);
                return true;
            }
        }

        return false;

    }

    public void displayAvailableBooks(){
        // display available books
        for(Book b : books){
            if(b.isAvailable){
                b.getBookDetails();
            }
        }
    }


}
