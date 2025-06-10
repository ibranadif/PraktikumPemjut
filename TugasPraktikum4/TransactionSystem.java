package TugasPraktikum4;

public class TransactionSystem {

    public static boolean autentikasi(Customer customer, String pinMasukkan) {
        if (customer.isAkunDiblokir()) {
            System.out.println("Akun diblokir karena 3 kesalahan autentikasi.");
            return false;
        }
        
        if (customer.getPin().equals(pinMasukkan)) {
            return true;
        } else {
            customer.tambahSalahMasuk();
            System.out.println("PIN salah, Anda sudah " + customer.getSalahMasuk() + " kali mencoba.");
            return false;
        }
    }

    public static boolean transaksiPembelian(Customer customer, double jumlahPembelian) {
        if (customer.getSaldo() < 10000) {
            System.out.println("Saldo minimal Rp 10.000 tidak tercapai. Transaksi gagal.");
            return false;
        }
        
        double cashback = hitungCashback(customer, jumlahPembelian);
        if (jumlahPembelian > 1000000) {
            System.out.println("Cashback yang didapat: Rp " + cashback);
            customer.setSaldo(customer.getSaldo() + cashback);
        }
        
        customer.setSaldo(customer.getSaldo() - jumlahPembelian);
        System.out.println("Pembelian berhasil. Saldo tersisa: Rp " + customer.getSaldo());
        return true;
    }

    public static boolean topUp(Customer customer, double jumlahTopUp) {
        if (jumlahTopUp <= 0) {
            System.out.println("Jumlah top-up tidak valid.");
            return false;
        }
        
        customer.setSaldo(customer.getSaldo() + jumlahTopUp);
        System.out.println("Top-up berhasil. Saldo sekarang: Rp " + customer.getSaldo());
        return true;
    }

    public static double hitungCashback(Customer customer, double jumlahPembelian) {
        double cashback = 0;
        String tipePelanggan = customer.getNomorPelanggan().substring(0, 2);

        switch (tipePelanggan) {
            case "38": // Silver
                if (jumlahPembelian > 1000000) {
                    cashback = jumlahPembelian * 0.05; // 5%
                }
                break;
            case "56": // Gold
                if (jumlahPembelian > 1000000) {
                    cashback = jumlahPembelian * 0.07; // 7%
                } else {
                    cashback = jumlahPembelian * 0.02; // 2%
                }
                break;
            case "74": // Platinum
                if (jumlahPembelian > 1000000) {
                    cashback = jumlahPembelian * 0.10; // 10%
                } else {
                    cashback = jumlahPembelian * 0.05; // 5%
                }
                break;
            default:
                System.out.println("Tipe pelanggan tidak valid.");
                break;
        }
        return cashback;
    }
}
