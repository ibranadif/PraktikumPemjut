package TugasPraktikum7;

class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return "[KueJadi] " + super.toString() + ", Jumlah: " + jumlah;
    }
}