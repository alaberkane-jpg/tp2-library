package library;

public class Copy {

	
	
	
	
	
	


    private int inventoryNumber;
    private Book book;
    private boolean available;

    public Copy(int inventoryNumber, Book book) {
        this.inventoryNumber = inventoryNumber;
        this.book = book;
        this.available = true;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Copy is already borrowed");
        }

        available = false;
    }

    public void giveBack() {
        if (available) {
            throw new IllegalStateException("Copy is not borrowed");
        }

        available = true;
    }

    @Override
    public String toString() {
        return "Copy number: " + inventoryNumber
                + ", Book: " + book.getTitle()
                + ", Available: " + available;
    }
}


