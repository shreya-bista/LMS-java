import java.util.Date;

public class Loan {
    public Date loanDate;
    public Date returnDate;
    public Date dueDate;
    public Patron patron;
    public Book book;
    public int charge;

    public Loan(){}

    public boolean createLoan(Book book, Patron patron){
        // Method for creating a loan
        this.book = book;
        this.patron = patron;


        if(!book.isAvailable) {
            System.out.println(book.bookTitle + " is unavailable!");
            return false;
        }

        book.markAsBorrowed();

        Date dateInstance = new Date();

        // set due date
        dateInstance.setTime(dateInstance.getTime() + 7 * 24 * 60 * 60 * 1000);

        this.dueDate = dateInstance;
        this.loanDate = new Date();

        return true;
    }

//    public void getLoanDetails(){
//        // Method for getting loan details
//        System.out.println("Printing loan details: ");
//        System.out.println("Patron name: "+ this.patron.name + "\n" + "Book name: " + this.book.bookTitle + "\n" + "Due date: "+ this.dueDate + "\n" + "Return Date: "+ this.returnDate + "\n" +"Loan Date: "+ this.loanDate);
//
//       System.out.println();
//    }

    public void completeLoan(){
        // Method for completing loan
        if(this.book.isAvailable) {
            System.out.println(book.bookTitle + " has not been borrowed!");
            return;
        }

        this.returnDate = new Date();
        this.book.markAsReturned();
    }


    // calculate overdue charge
    public void calculateOverdueCharge(){
        
        // Method for calculating overdue charge based on due date and current date if current date exceeds due date start charging $1 per day
        Date currentDate = new Date();

        if(currentDate.after(this.dueDate)){
            int charge = (int) (currentDate.getTime() - this.dueDate.getTime());
            System.out.println("Overdue charge: $" + charge);
            this.charge = charge;
        }
    }

    @Override
    public String toString() {
        // Method for printing loan details
        return "Loan{" +
                "loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", dueDate=" + dueDate +
                ", patron=" + patron +
                ", book=" + book +
                ", charge=" + charge +
                '}';
    }
}
