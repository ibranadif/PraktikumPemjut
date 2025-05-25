package Tugas2Praktikum;

// Kelas Pegawai
class Pegawai {
    // Atribut pegawai
    String nama;
    String jabatan;
    double gajiPokok;
    double tunjangan;
    double potongan;
    double bonus;

    // Default Constructor
    public Pegawai() {
        this.nama = "";
        this.jabatan = "";
        this.gajiPokok = 0.0;
        this.tunjangan = 0.0;
        this.potongan = 0.0;
        this.bonus = 0.0;
    }

    // Overloading Constructor
    public Pegawai(String nama, String jabatan, double gajiPokok, double tunjangan, double potongan, double bonus) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
        this.potongan = potongan;
        this.bonus = bonus;
    }

    // Instance Method untuk menghitung total gaji
    public double hitungTotalGaji() {
        return gajiPokok + tunjangan + bonus - potongan;
    }

    // Instance Method untuk menampilkan informasi lengkap pegawai
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Gaji Pokok: " + gajiPokok);
        System.out.println("Tunjangan: " + tunjangan);
        System.out.println("Potongan: " + potongan);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Gaji: " + hitungTotalGaji());
    }

    // Instance Method untuk menambahkan bonus
    public void tambahBonus(double tambahanBonus) {
        this.bonus += tambahanBonus;
    }
}

// Main Class untuk menguji Pegawai
public class Main {
    public static void main(String[] args) {
        // Menggunakan Default Constructor
        Pegawai pegawai1 = new Pegawai();
        pegawai1.nama = "Andi";
        pegawai1.jabatan = "Manager";
        pegawai1.gajiPokok = 5000000;
        pegawai1.tunjangan = 1500000;
        pegawai1.potongan = 500000;
        pegawai1.bonus = 1000000;

        // Menampilkan informasi pegawai1
        System.out.println("Informasi Pegawai 1:");
        pegawai1.displayInfo();

        // Menambahkan bonus
        System.out.println("\nMenambahkan bonus 500000 untuk Pegawai 1...");
        pegawai1.tambahBonus(500000);

        // Menampilkan informasi setelah bonus ditambahkan
        System.out.println("Informasi Pegawai 1 setelah bonus ditambahkan:");
        pegawai1.displayInfo();

        // Menggunakan Overloading Constructor
        Pegawai pegawai2 = new Pegawai("Budi", "Staf", 4000000, 1000000, 200000, 500000);

        // Menampilkan informasi pegawai2
        System.out.println("\nInformasi Pegawai 2:");
        pegawai2.displayInfo();
    }
}
