
package id.ac.polinema.library;

public class Book extends LibraryItem {

    private String isbn;
    private Author author;

    public Book(String isbn, String title, int year) {
        this(isbn, title, year, null);
    }

    public Book(String isbn, String title, int year, Author author) {
        super(title, year);

        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "ISBN cannot be null or empty"
            );
        }

        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public int loanDays() {
        return 14;
    }

    @Override
    public String describe() {
        String authorName = (author == null)
                ? "Unknown"
                : author.getName();

        return super.describe() + " by " + authorName;
    }
}
