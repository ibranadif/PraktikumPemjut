package TugasPraktikum4;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("3812345678", "Ahmad", "1234", 50000);
        
        if (TransactionSystem.autentikasi(customer1, "1234")) {
            TransactionSystem.transaksiPembelian(customer1, 1200000);
        }

        if (TransactionSystem.autentikasi(customer1, "1234")) {
            TransactionSystem.topUp(customer1, 50000);
        }

        if (TransactionSystem.autentikasi(customer1, "0000")) {
            System.out.println("Berhasil autentikasi.");
        } else {
            System.out.println("Gagal autentikasi.");
        }
    }
}
