package TugasPraktikum4;

public class Customer {
    private double saldo;
    private String nomorPelanggan;
    private String nama;
    private String pin;
    private int salahMasuk = 0; 

    public Customer(String nomorPelanggan, String nama, String pin, double saldo) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void tambahSalahMasuk() {
        salahMasuk++;
    }

    public int getSalahMasuk() {
        return salahMasuk;
    }

    // Cek jika akun diblokir
    public boolean isAkunDiblokir() {
        return salahMasuk >= 3;
    }
}
