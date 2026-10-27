
package id.ac.polinema.library;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String title, int year) {
        this(title, year, 1);
    }

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        setIssueNumber(issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be greater than zero");
        }

        this.issueNumber = issueNumber;
    }
}
