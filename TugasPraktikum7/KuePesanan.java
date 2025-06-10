package TugasPraktikum7;

class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    @Override
    public double hitungHarga() {
        return harga * berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public String toString() {
        return "[KuePesanan] " + super.toString() + ", Berat: " + berat;
    }
}