package TugaspPraktikum5;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Fitur Aritmatika =====");
        System.out.println("Penjumlahan 10 + 5 = " + Aritmatika.penjumlahan(10, 5));
        System.out.println("Pengurangan 10 - 5 = " + Aritmatika.pengurangan(10, 5));

        Aritmatika hitung = new Aritmatika();
        System.out.println("Perkalian 10 * 5 = " + hitung.perkalian(10, 5));
        System.out.println("Pembagian 10 / 5 = " + hitung.pembagian(10, 5));
        hitung.sederhana(20, 60); // Output: 1/3

        System.out.println("\n===== Fitur CV. Labkomdas (Jaket) =====");
        Jaket transaksi = new Jaket();
        transaksi.beliJaketA(120); // diskon
        transaksi.beliJaketB(50);  // normal
        transaksi.beliJaketC(101); // diskon
        transaksi.tampilkanTotal();
    }
}
