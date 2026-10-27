package id.ac.polinema.library;

/**
 * Bagian 2 dan 3: buku perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setAuthor, getAuthor, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas
 * constructor:
 * public String isbn;
 * public ____ title;
 * public ____ year;
 * public ____ available;
 */
public class Book extends LibraryItem {
    private String isbn;
    private Author author;

    /**
     * Membuat buku baru yang masih tersedia (belum dipinjam).
     * Bagian 3: isbn tidak boleh kosong; title dan year divalidasi seperti
     * setter-nya.
     */
    public Book(String isbn, String title, int year) {
        // TODO Bantuan: isi semua field. Buku baru: apakah sedang dipinjam atau tidak?
        // Bagian 3: aturan validasi judul dan tahun sama dengan setter. Bisakah
        // constructor
        // memakai setter-nya?
        //
        // Kerangka (Bagian 2):
        // this.isbn = isbn;
        // this.title = ____;
        // this.year = ____;
        // this.available = ____;
        super(title, year);

        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException( "ISBN cannot be null or empty");
        }
        this.isbn = isbn;
        this.author = null;
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
}
