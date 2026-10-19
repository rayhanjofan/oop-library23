package id.ac.polinema.library;

/**
 * Bagian 3: anggota perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 * private ____ memberId;
 * private ____ name;
 * private int loanCount; // nilai awal 0
 */
    public class Member {

    private String memberId;
    private String name;
    private int loanCount;

    /**
     * Membuat anggota yang belum punya pinjaman.
     * memberId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Member(String memberId, String name) {
        // TODO Bantuan: validasi dulu sebelum mengisi field. Aturan nama sama dengan
        // setName.
        if (memberId == null || memberId.isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");
        }
        this.memberId = memberId;
        // Bagian 4: kartu anggota juga dibuat di sini (lihat diagram Bagian 4).
        //
        // Kerangka:
        // if (memberId == null || ____) {
        // throw new IllegalArgumentException("____");
        // }
        // this.memberId = memberId;
        // setName(____);
        setName(name);
        this.loanCount = 0;
    }

    public String getMemberId() {
        // TODO Bantuan: kembalikan data yang disimpan constructor.
        return memberId;
    }

    public String getName() {
        // TODO Bantuan: sama seperti getMemberId.
        return name;
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        // TODO Bantuan: periksa dulu, baru isi field.
        //
        // Kerangka:
        //   if (name == null || ____) {
        //       throw new IllegalArgumentException("____");
        //   }
        //   this.name = name;
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getLoanCount() {
        // TODO Bantuan: kembalikan jumlah pinjaman saat ini.
        return loanCount;
    }

    /** True jika anggota masih boleh meminjam (batasnya 3 pinjaman). */
    public boolean canBorrow() {
        // TODO Bantuan: apakah perlu field baru, atau cukup dihitung dari data yang
        // sudah ada?
        //
        // Kerangka:
        // return loanCount ____ 3;
        return loanCount < 3;
    }

    /**
     * Menambah jumlah pinjaman. Jika sudah di batas, tidak berubah dan hasilnya
     * false.
     */
    public boolean addLoan() {
        // TODO Bantuan: periksa batas dulu. Adakah method lain di kelas ini yang sudah
        // menjawab pertanyaan "boleh atau tidak"?
        //
        // Kerangka:
        // if (!____) {
        // return false;
        // }
        // loanCount++;
        // return true;
        if (!canBorrow()) {
            return false;
        }
        loanCount++;
        return true;
    }

    /**
     * Mengurangi jumlah pinjaman. Jika sudah tidak ada pinjaman, tidak berubah dan
     * hasilnya false.
     */
    public boolean returnLoan() {
        // TODO Bantuan: batas bawah jumlah pinjaman adalah berapa?
        //
        // Kerangka:
        // if (loanCount == ____) {
        // return false;
        // }
        // loanCount--;
        // return true;
        if (loanCount == 0) {
            return false;
        }
        loanCount--;
        return true;
    }
}
