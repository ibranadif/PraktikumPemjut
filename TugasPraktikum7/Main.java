package TugasPraktikum7;

public class Main {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        // Mengisi array dengan 20 objek campuran
        daftarKue[0] = new KuePesanan("Kue Lapis", 3000, 2);
        daftarKue[1] = new KueJadi("Donat", 1500, 5);
        daftarKue[2] = new KuePesanan("Brownies", 5000, 1.2);
        daftarKue[3] = new KueJadi("Cupcake", 2000, 4);
        daftarKue[4] = new KuePesanan("Bolu Kukus", 3500, 2.5);
        daftarKue[5] = new KueJadi("Kue Cubit", 1000, 6);
        daftarKue[6] = new KuePesanan("Lemper", 2500, 3);
        daftarKue[7] = new KueJadi("Pisang Molen", 1800, 5);
        daftarKue[8] = new KuePesanan("Klepon", 2000, 1.8);
        daftarKue[9] = new KueJadi("Martabak Mini", 3000, 3);
        daftarKue[10] = new KuePesanan("Bika Ambon", 6000, 1.5);
        daftarKue[11] = new KueJadi("Serabi", 2500, 4);
        daftarKue[12] = new KuePesanan("Kue Pepe", 3200, 2.2);
        daftarKue[13] = new KueJadi("Nastar", 4000, 3);
        daftarKue[14] = new KuePesanan("Dadar Gulung", 2700, 2.8);
        daftarKue[15] = new KueJadi("Putri Salju", 4500, 3);
        daftarKue[16] = new KuePesanan("Onde-onde", 2900, 2.1);
        daftarKue[17] = new KueJadi("Roti Bakar", 3500, 2);
        daftarKue[18] = new KuePesanan("Kue Lumpur", 3100, 1.9);
        daftarKue[19] = new KueJadi("Lapis Legit", 5000, 1.5);

        double totalHarga = 0;
        double totalHargaPesanan = 0, totalBerat = 0;
        double totalHargaJadi = 0, totalJumlah = 0;
        Kue kueTermahal = daftarKue[0];

        // Menampilkan semua kue dan menghitung total harga
        System.out.println("== Daftar Semua Kue ==");
        for (Kue kue : daftarKue) {
            System.out.println(kue.toString());

            double hargaAkhir = kue.hitungHarga();
            totalHarga += hargaAkhir;

            if (kue instanceof KuePesanan) {
                totalHargaPesanan += hargaAkhir;
                totalBerat += ((KuePesanan) kue).getBerat();
            } else if (kue instanceof KueJadi) {
                totalHargaJadi += hargaAkhir;
                totalJumlah += ((KueJadi) kue).getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }
        }

        // Menampilkan hasil perhitungan total
        System.out.println("\n== Ringkasan Total ==");
        System.out.println("Total Harga Semua Kue        : Rp" + totalHarga);
        System.out.println("Total Harga Kue Pesanan      : Rp" + totalHargaPesanan);
        System.out.println("Total Berat Kue Pesanan      : " + totalBerat + " kg");
        System.out.println("Total Harga Kue Jadi         : Rp" + totalHargaJadi);
        System.out.println("Total Jumlah Kue Jadi        : " + totalJumlah + " buah");

        // Menampilkan kue dengan harga tertinggi
        System.out.println("\n== Kue dengan Harga Terbesar ==");
        System.out.println(kueTermahal.toString());
        System.out.println("Harga Akhir: Rp" + kueTermahal.hitungHarga());
    }
}