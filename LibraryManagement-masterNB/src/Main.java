import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    private static void createLibrary() {
        // Create some sample books, patrons and loans,


        library.createPatron("Alice Johnson", 101, "Student");
        library.createPatron("Bob Smith", 102, "Tutor");
        library.createPatron("Carol Williams", 103, "Member");
        library.createPatron("David Brown", 104, "Student");
        library.createPatron("Eve Davis", 105, "Tutor");



        library.addBook("To Kill a Mockingbird", "Harper Lee", "FIC001", true, "Fiction");
        library.addBook("The Hunger Games", "Suzanne Collins", "ACT001", true, "Action");
        library.addBook("Gone Girl", "Gillian Flynn", "THR001", true, "Thriller");
        library.addBook("Good Omens", "Neil Gaiman & Terry Pratchett", "COM001", true, "Comedy");
        library.addBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "NON001", true, "Non-Fiction");
        library.addBook("The Girl with the Dragon Tattoo", "Stieg Larsson", "MYS001", true, "Mystery");
        library.addBook("The Power of Habit", "Charles Duhigg", "SLF001", true, "Self-Help");
        library.addBook("Becoming", "Michelle Obama", "MEM001", true, "Memoir");
        library.addBook("Ender's Game", "Orson Scott Card", "SCI001", true, "Science Fiction");

        library.createLoan(101, "To Kill a Mockingbird");
        library.createLoan(102, "The Power of Habit");
        library.createLoan(101, "Ender's Game");



    }
    public static void main(String[] args) {

        // Create a Library object and all menus are created here, with operations handled in other classes

        boolean exit = false;
        System.out.println("Welcome to the Library Management System!");
        createLibrary();

        while (!exit) {
            displayMenu();
            int choice = getChoice();

            if (choice <=-1 && choice >= 12) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addPatron();
                    break;
                case 4:
                    removePatron();
                    break;
                case 5:
                    checkOutBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    displayBooks();
                    break;
                case 8:
                    displayPatrons();
                    break;
                case 9:
                library.displayAvailableBooks();
                break;

                case 10:
                library.displayCategories();
                break;

                case 11:
                library.getLoans();
                break;  

                case 0:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {

        // Displays menus supported by current library management system

        System.out.println("\nMain Menu:");
        System.out.println("0. Exit");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Add a Patron");
        System.out.println("4. Remove a Patron");
        System.out.println("5. Check Out a Book");
        System.out.println("6. Return a Book");
        System.out.println("7. Display Books");
        System.out.println("8. Display Patrons");
        System.out.println("9. Display Available Books");
        System.out.println("10. Display Categories");
        System.out.println("11. Display Loaned Books");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {

        // Returns the choice entered by the user

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }

    private static void addBook() {

        // Adds a book to the library

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        // Book book = new Book(title, author, isbn, true, new Category(category, category));
        library.addBook(title, author, isbn, true, category);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {

        // Removes a book from the library

        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();

        if (library.removeBook(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book cannot be removed");
        }
    }

    private static void addPatron() {

        // Adds a patron to the library

        System.out.print("Enter Patron name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patron Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patron Type: ");
        String type = scanner.nextLine();

        library.createPatron(name, id, type);
        System.out.println("Patron added successfully.");
    }

    private static void removePatron() {

        // Removes a patron from the library

        System.out.print("Enter patron id to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (library.removePatron(id)) {
            System.out.println("Patron removed successfully.");
        } else {
            System.out.println("Patron cannot be removed");
        }
    }

    private static void checkOutBook() {

        // Checks out a book

        System.out.print("Enter patron Id: ");
        int patronId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book title to check out: ");
        String bookTitle = scanner.nextLine();

        if (library.createLoan(patronId, bookTitle)) {
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Could not check out book.");
        }
    }

    private static void returnBook() {

        // Returns a book

        System.out.print("Enter patron Id: ");
        int patronId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book title to return: ");
        String bookTitle = scanner.nextLine();

        if (library.returnBook(patronId, bookTitle)) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Could not return book. Either patron or book not found.");
        }
    }

    private static void displayBooks() {

        // Displays all books

        List<Book> books = library.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void displayPatrons() {

        // Displays all patrons

        List<Patron> patrons = library.getPatrons();
        if (patrons.isEmpty()) {
            System.out.println("No patrons in the library.");
        } else {
            System.out.println("Registered patrons:");
            for (Patron patron : patrons) {
                System.out.println(patron);
            }
        }
    }
    
    public void test(){

        

        Library lib = new Library();

        lib.addBook("Science","Ram","science",true,"thriller");
        lib.addBook("Maths","Ram","maths",true,"fiction");
        lib.addBook("Social","Ram","social",true,"action");
        lib.addBook("English","Ram","english",true,"comedy");
        lib.addBook("Health","Ram","health",true,"fiction");

        System.out.println("\nDisplaying Books...");

        ArrayList<Book> books = lib.getBooks();

        // Updating book author
        books.get(1).setBookDetails("Optional Maths","Hari","opt");

        System.out.println("\nDisplaying updated results...");
        books.get(1).getBookDetails();

       lib.createPatron("Sagar",1,"Premium");
       lib.createPatron("Shreya",2,"Bronze");
       lib.createPatron("Hassan",3,"Silver");
       lib.createPatron("Nishant",4,"Gold");

       System.out.println("\nDisplaying Patrons...");

       ArrayList<Patron> patrons = lib.getPatrons();

       // Creating loans
       lib.createLoan(patrons.get(0).id,books.get(2).bookTitle);
        lib.createLoan(patrons.get(1).id,books.get(0).bookTitle);
        lib.createLoan(patrons.get(2).id,books.get(1).bookTitle);
        lib.createLoan(patrons.get(3).id,books.get(3).bookTitle);

        // Displaying loans
        System.out.println("\nDisplaying Loans...");
       ArrayList<Loan> loans = lib.getLoans();

       // Returning loans
        loans.get(0).completeLoan();
        loans.get(1).completeLoan();

        //
        System.out.println("\nDisplaying Loans after returns...");
        lib.getLoans();
    }
}