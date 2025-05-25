public class Studio {
    private int nomorStudio;
    private int kapasitasKursi;
    private Film film;

    // Constructor
    public Studio(int nomorStudio, int kapasitasKursi, Film film) {
        this.nomorStudio = nomorStudio;
        this.kapasitasKursi = kapasitasKursi;
        this.film = film;
    }

    // Getter dan Setter
    public int getNomorStudio() {
        return nomorStudio;
    }

    public int getKapasitasKursi() {
        return kapasitasKursi;
    }

    public Film getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Studio " + nomorStudio + " | Kapasitas: " + kapasitasKursi + " kursi | Film: " + film.getJudul() +
               " | Jam Tayang: " + film.getJamTayang();
    }
}
