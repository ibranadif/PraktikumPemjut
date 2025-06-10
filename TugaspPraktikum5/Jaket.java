package TugaspPraktikum5;

import java.text.NumberFormat;
import java.util.Locale;

public class Jaket {
    public static final int HARGA_A = 100000;
    public static final int HARGA_B = 125000;
    public static final int HARGA_C = 175000;

    private int totalHarga;

    private final NumberFormat formatter = NumberFormat.getInstance(new Locale("in", "ID"));

    public void beliJaketA(int jumlah) {
        int harga = (jumlah > 100) ? 95000 : HARGA_A;
        int subtotal = jumlah * harga;
        totalHarga += subtotal;
        System.out.println("Beli Jaket A: " + jumlah + " pcs, Harga per biji: Rp " + formatter.format(harga));
    }

    public void beliJaketB(int jumlah) {
        int harga = (jumlah > 100) ? 120000 : HARGA_B;
        int subtotal = jumlah * harga;
        totalHarga += subtotal;
        System.out.println("Beli Jaket B: " + jumlah + " pcs, Harga per biji: Rp " + formatter.format(harga));
    }

    public void beliJaketC(int jumlah) {
        int harga = (jumlah > 100) ? 160000 : HARGA_C;
        int subtotal = jumlah * harga;
        totalHarga += subtotal;
        System.out.println("Beli Jaket C: " + jumlah + " pcs, Harga per biji: Rp " + formatter.format(harga));
    }

    public void tampilkanTotal() {
        System.out.println("Total Harga Pembelian: Rp " + formatter.format(totalHarga));
    }

    public void resetTotal() {
        totalHarga = 0;
    }
}
