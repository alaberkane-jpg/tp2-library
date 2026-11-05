package library;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Library {

	
	





    private List<Book> books;
    private List<Copy> copies;
    private List<Member> members;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        copies = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a physical copy
    public void addCopy(Copy copy) {
        copies.add(copy);
    }

    // Register a member
    public void addMember(Member member) {
        members.add(member);
    }

    // Get all books
    public List<Book> getBooks() {
        return books;
    }

    // Get all copies
    public List<Copy> getCopies() {
        return copies;
    }

    // Get all members
    public List<Member> getMembers() {
        return members;
    }

    // Get all loans
    public List<Loan> getLoans() {
        return loans;
    }

    // Lend a copy to a member
    public Loan lendCopy(int inventoryNumber, int memberNumber,
                         LocalDate startDate) {

        Copy selectedCopy = null;
        Member selectedMember = null;

        // Find the requested copy
        for (Copy copy : copies) {
            if (copy.getInventoryNumber() == inventoryNumber) {
                selectedCopy = copy;
                break;
            }
        }

        // Find the member
        for (Member member : members) {
            if (member.getMemberNumber() == memberNumber) {
                selectedMember = member;
                break;
            }
        }

        if (selectedCopy == null) {
            throw new IllegalArgumentException("Copy not found");
        }

        if (selectedMember == null) {
            throw new IllegalArgumentException("Member not found");
        }

        if (!selectedCopy.isAvailable()) {
            throw new IllegalStateException("Copy is not available");
        }

        // Check the maximum of 5 open loans
        int activeLoans = 0;

        for (Loan loan : loans) {
            if (loan.getMember().getMemberNumber() == memberNumber
                    && loan.isOpen()) {
                activeLoans++;
            }
        }

        if (activeLoans >= 5) {
            throw new IllegalStateException(
                    "Member cannot borrow more than 5 books");
        }

        selectedCopy.borrow();

        Loan newLoan = new Loan(selectedCopy, selectedMember, startDate);
        loans.add(newLoan);

        return newLoan;
    }

    // Return a borrowed copy
    public void returnCopy(int inventoryNumber, LocalDate returnDate) {

        for (Loan loan : loans) {

            if (loan.getCopy().getInventoryNumber() == inventoryNumber
                    && loan.isOpen()) {

                loan.returnLoan(returnDate);
                loan.getCopy().giveBack();

                return;
            }
        }

        throw new IllegalArgumentException("No open loan found for this copy");
    }
}


