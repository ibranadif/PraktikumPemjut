import java.util.*;

class Pemain {
    int tinggiBadan;
    int beratBadan;

    public Pemain(int tinggiBadan, int beratBadan) {
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggiBadan + " cm, Berat: " + beratBadan + " kg";
    }
}

public class Futsal {
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

        // a. Mengurutkan berdasarkan Tinggi Badan (Ascending)
        Collections.sort(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        System.out.println("Tim A - Urut Tinggi Badan Ascending:");
        timA.forEach(System.out::println);

        // b. Mengurutkan berdasarkan Berat Badan (Descending)
        Collections.sort(timB, (p1, p2) -> Integer.compare(p2.beratBadan, p1.beratBadan));
        System.out.println("\nTim B - Urut Berat Badan Descending:");
        timB.forEach(System.out::println);

        // c. Mencari nilai maksimum dan minimum Tinggi Badan dan Berat Badan
        Pemain maxTinggiA = Collections.max(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        Pemain minTinggiA = Collections.min(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        Pemain maxBeratA = Collections.max(timA, Comparator.comparingInt(p -> p.beratBadan));
        Pemain minBeratA = Collections.min(timA, Comparator.comparingInt(p -> p.beratBadan));
        
        System.out.println("\nTim A - Tinggi Badan Maksimal: " + maxTinggiA + " & Minimal: " + minTinggiA);
        System.out.println("Tim A - Berat Badan Maksimal: " + maxBeratA + " & Minimal: " + minBeratA);

        // d. Menyalin seluruh anggota Tim B ke Tim C
        List<Pemain> timC = new ArrayList<>(timB);
        System.out.println("\nTim C (Salinan dari Tim B):");
        timC.forEach(System.out::println);
    }
}
