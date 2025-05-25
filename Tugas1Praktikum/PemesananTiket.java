import java.util.Scanner;

public class PemesananTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek film
        Film film1 = new Film("Avengers: Endgame", "Action", "10:00", 50000);
        Film film2 = new Film("Frozen 2", "Animation", "13:00", 45000);
        Film film3 = new Film("The Lion King", "Adventure", "16:00", 48000);

        // Membuat objek studio
        Studio studio1 = new Studio(1, 100, film1);
        Studio studio2 = new Studio(2, 80, film2);
        Studio studio3 = new Studio(3, 120, film3);

        // Menampilkan informasi film dan studio
        System.out.println("Daftar Film yang Tersedia:");
        System.out.println(studio1);
        System.out.println(studio2);
        System.out.println(studio3);

        // Memilih film dan studio
        System.out.print("\nPilih Studio (1/2/3): ");
        int pilihStudio = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Studio studioDipilih = null;
        Film filmDipilih = null;
        switch (pilihStudio) {
            case 1:
                studioDipilih = studio1;
                filmDipilih = studio1.getFilm();
                break;
            case 2:
                studioDipilih = studio2;
                filmDipilih = studio2.getFilm();
                break;
            case 3:
                studioDipilih = studio3;
                filmDipilih = studio3.getFilm();
                break;
            default:
                System.out.println("Pilihan studio tidak valid.");
                return;
        }

        // Memilih nomor kursi
        System.out.print("Pilih nomor kursi (1-" + studioDipilih.getKapasitasKursi() + "): ");
        int nomorKursi = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Memasukkan nama penonton
        System.out.print("Masukkan nama penonton: ");
        String namaPenonton = scanner.nextLine();

        // Membuat tiket
        String nomorTiket = "TKT" + (int)(Math.random() * 1000);  // Nomor tiket acak
        Tiket tiket = new Tiket(nomorTiket, filmDipilih, studioDipilih, nomorKursi, namaPenonton);

        // Menampilkan informasi tiket
        System.out.println("\nTiket berhasil dipesan!");
        System.out.println(tiket);
    }
}
