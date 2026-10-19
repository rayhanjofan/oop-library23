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
public class Book {
    private String isbn;
    private String title;
    private int year;
    private boolean available;
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
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN tidak boleh kosong.");
        }
        this.isbn = isbn;
        this.available = true;
        // Kerangka (Bagian 3): ganti dua baris title dan year dengan pemanggilan
        // setter.
        // setTitle(____);
        // setYear(____);
        setTitle(title);
        setYear(year);

    }

    public String getIsbn() {
        // TODO Bantuan: kembalikan data yang disimpan constructor.
        //
        // Kerangka:
        // return ____;
        return isbn;
    }

    public String getTitle() {
        // TODO Bantuan: sama seperti getIsbn.
        return title;
    }

    /**
     * Bagian 3. Mengubah judul. Judul null, kosong, atau hanya spasi ditolak
     * dengan IllegalArgumentException, dan judul lama tetap.
     */
    public void setTitle(String title) {
        // TODO Bantuan: periksa dulu, baru isi field. Class String punya method untuk
        // memeriksa teks kosong atau hanya spasi. Jangan lupa kemungkinan null.
        //
        // Kerangka:
        // if (title == null || ____) {
        // throw new IllegalArgumentException("____");
        // }
        // this.title = title;
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong atau hanya spasi");
        }
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        // TODO Bantuan: sama seperti getIsbn.
        return year;
    }

    /** True jika buku sedang ada di perpustakaan (tidak dipinjam). */
    public boolean isAvailable() {
        // TODO Bantuan: field apa yang menyimpan status pinjam?
        //
        // Kerangka:
        // return ____;
        return available;
    }

    /**
     * Meminjam buku. Berhasil (true) jika buku tersedia. Jika buku sedang
     * dipinjam, hasilnya false dan keadaan buku tidak berubah.
     */
    public boolean checkOut() {
        // TODO Bantuan: apa yang harus kamu periksa lebih dulu sebelum mengubah status?
        // Method ini punya dua jalur return yang berbeda.
        //
        // Kerangka:
        // if (____) {
        // return false;
        // }
        // ____ = false;
        // return true;
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    /** Mengembalikan buku: buku bisa dipinjam lagi. */
    public void returnItem() {
        // TODO Bantuan: satu baris saja. Status apa yang berubah?
        //
        // Kerangka:
        // ____ = true;
        available = true;
    }

    /**
     * Bagian 3. Mengubah tahun terbit. Tahun 0 atau negatif ditolak dengan
     * IllegalArgumentException, dan tahun lama tetap.
     */
    public void setYear(int year) {
        // TODO Bantuan: pola yang sama dengan setTitle. Apa syarat tahun yang valid?
        //
        // Kerangka:
        // if (year ____ 0) {
        // throw new IllegalArgumentException("____");
        // }
        // this.year = year;
        if (year <= 0) {
            throw new IllegalArgumentException("Tahun terbit harus diatas 0");
        }
        this.year = year;
    }
}
