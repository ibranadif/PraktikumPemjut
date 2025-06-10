package TugaspPraktikum5;

public class Aritmatika {

    public static int penjumlahan(int a, int b) {
        return a + b;
    }

    public static int pengurangan(int a, int b) {
        return a - b;
    }

    public int perkalian(int a, int b) {
        return a * b;
    }

    public double pembagian(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Pembagian dengan nol tidak diperbolehkan.");
            return 0;
        }
    }

    public void sederhana(int pembilang, int penyebut) {
        int a = pembilang;
        int b = penyebut;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        pembilang /= a;
        penyebut /= a;

        System.out.println("Pecahan yang disederhanakan: " + pembilang + "/" + penyebut);
    }
}
