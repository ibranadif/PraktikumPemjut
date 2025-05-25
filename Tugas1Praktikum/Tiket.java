public class Tiket {
    private String nomorTiket;
    private Film film;
    private Studio studio;
    private int nomorKursi;
    private String namaPenonton;

    // Constructor
    public Tiket(String nomorTiket, Film film, Studio studio, int nomorKursi, String namaPenonton) {
        this.nomorTiket = nomorTiket;
        this.film = film;
        this.studio = studio;
        this.nomorKursi = nomorKursi;
        this.namaPenonton = namaPenonton;
    }

    // Getter dan Setter
    public String getNomorTiket() {
        return nomorTiket;
    }

    public Film getFilm() {
        return film;
    }

    public Studio getStudio() {
        return studio;
    }

    public int getNomorKursi() {
        return nomorKursi;
    }

    public String getNamaPenonton() {
        return namaPenonton;
    }

    @Override
    public String toString() {
        return "Tiket Nomor: " + nomorTiket + " | Nama Penonton: " + namaPenonton + " | Film: " + film.getJudul() +
               " | Studio: " + studio.getNomorStudio() + " | Kursi: " + nomorKursi + " | Jam Tayang: " + film.getJamTayang() +
               " | Harga: Rp " + film.getHargaTiket();
    }
}
