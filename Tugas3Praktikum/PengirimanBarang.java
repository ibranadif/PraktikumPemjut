package Tugas3Praktikum;

public class PengirimanBarang {
    private String namaPengirim;
    private String alamatTujuan;
    private double berat;
    private double biayaDasar;

    // Default constructor
    public PengirimanBarang() {
        this.namaPengirim = "";
        this.alamatTujuan = "";
        this.berat = 0;
        this.biayaDasar = 0;
    }

    // Overloading constructor
    public PengirimanBarang(String namaPengirim, String alamatTujuan, double berat, double biayaDasar) {
        this.namaPengirim = namaPengirim;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.biayaDasar = biayaDasar;
    }

    // Overloaded method: diskon persen
    public double hitungOngkir(double diskonPersen) {
        double diskon = biayaDasar * (diskonPersen / 100);
        return biayaDasar - diskon;
    }

    // Overloaded method: diskon persen + biaya tambahan
    public double hitungOngkir(double diskonPersen, double biayaTambahan) {
        double ongkirSetelahDiskon = hitungOngkir(diskonPersen);
        return ongkirSetelahDiskon + biayaTambahan;
    }

    // Overloaded method: berdasarkan jarak
    public double hitungOngkir(int jarak) {
        if (jarak > 50) {
            return biayaDasar + (biayaDasar * 0.10); // surcharge 10%
        } else {
            return biayaDasar - (biayaDasar * 0.05); // diskon 5%
        }
    }

    // Method info statis perusahaan logistik
    public void displayInfoLogistik() {
        System.out.println("=== PT. KirimCepat Logistik ===");
        System.out.println("Layanan Pengiriman Cepat dan Aman ke Seluruh Nusantara.");
        System.out.println("=========================================");
    }

    // Method untuk menampilkan detail pengiriman
    public void displayDetailPengiriman() {
        System.out.println("Nama Pengirim     : " + namaPengirim);
        System.out.println("Alamat Tujuan     : " + alamatTujuan);
        System.out.println("Berat Barang (kg) : " + berat);
        System.out.println("Biaya Dasar       : Rp " + biayaDasar);
    }
}
