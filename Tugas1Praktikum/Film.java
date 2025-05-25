public class Film {
    private String judul;
    private String genre;
    private String jamTayang;
    private double hargaTiket;

    // Constructor
    public Film(String judul, String genre, String jamTayang, double hargaTiket) {
        this.judul = judul;
        this.genre = genre;
        this.jamTayang = jamTayang;
        this.hargaTiket = hargaTiket;
    }

    // Getter dan Setter
    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public String getJamTayang() {
        return jamTayang;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    @Override
    public String toString() {
        return "Film: " + judul + " | Genre: " + genre + " | Jam Tayang: " + jamTayang + " | Harga: Rp " + hargaTiket;
    }
}
