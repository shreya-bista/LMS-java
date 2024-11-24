import java.util.List;

public class Book {
    public String bookTitle;
    public String bookAuthor;
    public String bookIdentifier;
    public boolean isAvailable;
    public Category category;

    public Book(String bookTitle, String bookAuthor, String bookIdentifier, boolean isAvailable,Category c){
        // Constructor for creating books with parameters
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIdentifier = bookIdentifier;
        this.isAvailable = isAvailable;
        this.category = c;
    }

    public Book(String bookTitle, String bookAuthor, String bookIdentifier, boolean isAvailable){
        // Constructor for creating books with parameters
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIdentifier = bookIdentifier;
        this.isAvailable = isAvailable;
        this.category = new Category("Other", "other");
    }

    public void setBookDetails(String bookTitle, String bookAuthor, String bookIdentifier){
        // Constructor for setting book details
         this.bookTitle = bookTitle;
         this.bookIdentifier =bookIdentifier;
         this.bookAuthor = bookAuthor;
    }

    public void getBookDetails(){
        // Method for getting book details
        System.out.println("Book Title: "+ this.bookTitle + "\n" + "Book Author: "+ this.bookAuthor + "\n" + "Book identifier: " + this.bookIdentifier + "\n" + "Genere: "+category.name);
        System.out.println();
    
    }

    public void markAsBorrowed(){
        // Method for marking a book as borrowed
            this.isAvailable = false;
    }

    public void markAsReturned(){
        // Method for marking a book as returned
            this.isAvailable = true;
    }

    public void changeCategory(Category c){
        // Method for changing book category
        this.category = c;
    }

    @Override
    public String toString() {
        // Method for printing book details
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookIdentifier='" + bookIdentifier + '\'' +
                ", isAvailable=" + isAvailable +
                ", category=" + category +
                '}';
    }


}
