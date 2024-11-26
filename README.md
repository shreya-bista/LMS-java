# Library Management System

## Description

This Library Management System is a Java based console application that allows librarians to manage books, patrons, and loans. 

## Features

- Add and remove books
- Add and remove patrons
- Check out books to patrons
- Return books
- Display all books in the library
- Display all registered patrons
- View available books
- View book categories
- Display current loans

## Project Structure

The project consists of the following main classes:

- `Main`: The entry point of the application, handling user interactions.
- `Library`: Manages the core library operations.
- `Book`: Represents a book in the library.
- `Patron`: Represents a library patron.
- `Loan`: Manages book loans.
- `Category`: Represents book categories.
- `Person`: Base class for Patron.

## How to Run

1. Install Java.
2. Clone this repository.
   
3. Navigate to the project directory
   ```
   cd library-management-system
   ```
4. Compile the Java files:
   ```
   javac *.java
   ```
5. Run the Main class:
   ```
   java Main
   ```

## Usage

When running the applicatin the following menu of options will be shown:

0. Exit
1. Add a Book
2. Remove a Book
3. Add a Patron
4. Remove a Patron
5. Check Out a Book
6. Return a Book
7. Display Books
8. Display Patrons
9. Display Available Books
10. Display Categories
11. Display Loaned Books

Enter the desired choice by entering the number corresponding to the action.

## Sample Data

The system is pre-loaded with sample data including:
- 5 patrons
- 9 books across various categories
- 3 initial loans

## License

This project is open source and available under the [MIT License](LICENSE).

