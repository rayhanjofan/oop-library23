package id.ac.polinema.library;

public class Librarian {

    // Dependensi: Tidak memiliki field sama sekali
    public Librarian() {
    }

    public boolean lend(Member member, Book book) {
        if (member == null || book == null) {
            return false;
        }
        // Syarat: anggota boleh meminjam DAN buku sedang tersedia
        if (member.canBorrow() && book.isAvailable()) {
            book.checkOut();
            member.addLoan();
            return true;
        }
        return false;
    }

    public boolean receive(Member member, Book book) {
        if (member == null || book == null) {
            return false;
        }
        // Syarat: buku sedang dipinjam (!available) DAN anggota memiliki riwayat
        // pinjaman (> 0)
        if (!book.isAvailable() && member.getLoanCount() > 0) {
            book.returnItem();
            member.returnLoan();
            return true;
        }
        return false;
    }
}   
