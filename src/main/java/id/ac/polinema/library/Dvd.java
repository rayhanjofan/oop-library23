
package id.ac.polinema.library;

public class Dvd extends LibraryItem {

    private int durationMinutes;

    public Dvd(String title, int year, int durationMinutes) {
        super(title, year);
        setDurationMinutes(durationMinutes);
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                "Duration must be greater than zero"
            );
        }

        this.durationMinutes = durationMinutes;
    }
}
