import java.util.*;

public class BinarySearchFutsal {
    public static void main(String[] args) {
        // Data Tim A dan Tim B
        List<Pemain> timA = Arrays.asList(
            new Pemain(168, 50),
            new Pemain(170, 60),
            new Pemain(165, 56),
            new Pemain(168, 55),
            new Pemain(172, 60),
            new Pemain(170, 70),
            new Pemain(169, 66),
            new Pemain(165, 56),
            new Pemain(171, 72),
            new Pemain(166, 56)
        );

        List<Pemain> timB = Arrays.asList(
            new Pemain(170, 66),
            new Pemain(167, 60),
            new Pemain(165, 59),
            new Pemain(166, 58),
            new Pemain(168, 58),
            new Pemain(175, 71),
            new Pemain(172, 68),
            new Pemain(171, 68),
            new Pemain(168, 65),
            new Pemain(169, 60)
        );

        // Sorting timA dan timB berdasarkan tinggi badan
        Collections.sort(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        Collections.sort(timB, Comparator.comparingInt(p -> p.tinggiBadan));

        // a) Mencari jumlah pemain Tim B dengan tinggi badan 168 dan 160
        long count168 = timB.stream().filter(p -> p.tinggiBadan == 168).count();
        long count160 = timB.stream().filter(p -> p.tinggiBadan == 160).count();

        System.out.println("Jumlah pemain Tim B dengan tinggi badan 168 cm: " + count168);
        System.out.println("Jumlah pemain Tim B dengan tinggi badan 160 cm: " + count160);

        // b) Mencari jumlah pemain Tim A dengan berat badan 56 kg dan 53 kg
        long count56 = timA.stream().filter(p -> p.beratBadan == 56).count();
        long count53 = timA.stream().filter(p -> p.beratBadan == 53).count();

        System.out.println("Jumlah pemain Tim A dengan berat badan 56 kg: " + count56);
        System.out.println("Jumlah pemain Tim A dengan berat badan 53 kg: " + count53);

        // c) Memeriksa apakah ada pemain Tim A yang mempunyai tinggi badan atau berat badan yang sama dengan pemain Tim B
        boolean matchFound = timA.stream().anyMatch(p -> 
            timB.stream().anyMatch(b -> b.tinggiBadan == p.tinggiBadan || b.beratBadan == p.beratBadan)
        );

        System.out.println("Apakah ada pemain di Tim A yang memiliki tinggi badan atau berat badan yang sama dengan pemain di Tim B? " + (matchFound ? "Ya" : "Tidak"));
    }
}
