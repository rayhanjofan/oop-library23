package id.ac.polinema.library;

public class LibraryItem {

    protected String title;
    protected int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        setTitle(title);
        setYear(year);
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than zero");
        }

        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean checkOut() {
        if (!available) {
            return false;
        }

        available = false;
        return true;
    }

    public void returnItem() {
        available = true;
    }
}
