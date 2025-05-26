package Tugas3Praktikum;

public class Main {
    public static void main(String[] args) {
        // Objek menggunakan default constructor
        PengirimanBarang pengiriman1 = new PengirimanBarang();
        pengiriman1.displayInfoLogistik();

        // Objek menggunakan overloading constructor
        PengirimanBarang pengiriman2 = new PengirimanBarang("Dewi Lestari", "Bandung", 3.5, 50000);

        // Tampilkan detail pengiriman
        pengiriman2.displayDetailPengiriman();
        System.out.println();

        // Uji hitungOngkir(double diskonPersen)
        double ongkirDiskon = pengiriman2.hitungOngkir(10); // 10% diskon
        System.out.println("Ongkir setelah diskon 10%     : Rp " + ongkirDiskon);

        // Uji hitungOngkir(double diskonPersen, double biayaTambahan)
        double ongkirDiskonTambahan = pengiriman2.hitungOngkir(10, 10000); // 10% diskon + Rp 10.000 biaya tambahan
        System.out.println("Ongkir + biaya tambahan       : Rp " + ongkirDiskonTambahan);

        // Uji hitungOngkir(int jarak)
        double ongkirJarak1 = pengiriman2.hitungOngkir(30); // ≤ 50 km
        double ongkirJarak2 = pengiriman2.hitungOngkir(70); // > 50 km
        System.out.println("Ongkir untuk jarak 30 km      : Rp " + ongkirJarak1);
        System.out.println("Ongkir untuk jarak 70 km      : Rp " + ongkirJarak2);
    }
}
