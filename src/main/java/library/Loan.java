package library;

import java.time.LocalDate;
public class Loan {

	
	
	
	
	
	



    private Copy copy;
    private Member member;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(Copy copy, Member member, LocalDate startDate) {
        this.copy = copy;
        this.member = member;
        this.startDate = startDate;
        this.dueDate = startDate.plusDays(14);
        this.returnDate = null;
    }

    public Copy getCopy() {
        return copy;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isOpen() {
        return returnDate == null;
    }

    public void returnLoan(LocalDate returnDate) {
        if (!isOpen()) {
            throw new IllegalStateException("Loan is already closed");
        }

        this.returnDate = returnDate;
    }

    public boolean isLate(LocalDate today) {
        return isOpen() && today.isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Loan: " + copy.getInventoryNumber()
                + ", Member: " + member.getName()
                + ", Start: " + startDate
                + ", Due: " + dueDate
                + ", Return: " + returnDate;
    }
}


