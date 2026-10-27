
package id.ac.polinema.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Library");

        Library library = new Library("Polinema Library");

        Author author = new Author("Robert Martin", "USA");

        Book book = new Book(
                "ISBN-001",
                "Clean Code",
                2008,
                author);

        Dvd dvd = new Dvd("Inception", 2010, 148);

        Magazine magazine = new Magazine("Tempo", 2024, 7);

        Member member = new Member("M001", "Budi");

        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);
        library.addMember(member);

        LibraryApp app = new LibraryApp(
                library,
                new Scanner(System.in),
                System.out);

        app.run();
    }
}
