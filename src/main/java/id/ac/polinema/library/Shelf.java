package id.ac.polinema.library;

public class Shelf {
    private String code;
    private Book[] books;
    private int count;

    public Shelf(String code) {
        this.code = code;
        this.books = new Book[5];
        this.count = 0;
    }

    public String getCode() {
        return code;
    }

    public int getBookCount() {
        return count;
    }

    public boolean addBook(Book book) {
        if (book == null || count >= books.length) {
            return false;
        }
        books[count] = book;
        count++;
        return true;
    }

    public Book findByIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i]; // Mengembalikan referensi objek Book yang sama
            }
        }
        return null;
    }

    public int countAvailable() {
        int availableCount = 0;
        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }
}
