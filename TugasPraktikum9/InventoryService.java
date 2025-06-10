package TugasPraktikum9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;

public class InventoryService {

    // Buat folder data jika belum ada
    public void initDataDirectory(Path dir) throws IOException {
        if (Files.notExists(dir)) {
            Files.createDirectories(dir);  // Membuat folder 'data' secara otomatis
        }
    }

    // Load daftar produk dari CSV
    public List<Product> loadProducts(Path csvPath) throws IOException {
        if (Files.exists(csvPath)) {
            List<String> lines = Files.readAllLines(csvPath);
            return lines.stream()
                        .skip(1) 
                        .map(Product::fromCsvLine)
                        .collect(Collectors.toList());
        }
        return new ArrayList<>(); 
    }

    // Simpan daftar produk ke CSV
    public void saveProducts(List<Product> products, Path csvPath) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("id,name,category,price,quantity"); // Menambahkan header ke dalam list

        // Menambahkan data produk ke dalam list
        for (Product product : products) {
            lines.add(product.toCsvLine());
        }

        // Menulis list ke file CSV
        Files.write(csvPath, lines);
    }

    // Pencarian produk berdasarkan nama (substring match)
    public List<Product> searchProducts(List<Product> products, String keyword) {
        return products.stream()
                       .filter(p -> p.getName().contains(keyword))
                       .collect(Collectors.toList());
    }

    // Sortir produk berdasarkan "price" atau "quantity"
    public void sortProducts(List<Product> products, String criteria) {
        if ("price".equals(criteria)) {
            products.sort(Comparator.comparingDouble(Product::getPrice));
        } else if ("quantity".equals(criteria)) {
            products.sort(Comparator.comparingInt(Product::getQuantity));
        }
    }

    // Filter produk berdasarkan rentang harga [min..max]
    public List<Product> filterByPrice(List<Product> products, double min, double max) {
        return products.stream()
                       .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                       .collect(Collectors.toList());
    }

    // Menu interaktif
    public void runMenu(List<Product> products) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== INVENTORY MANAGER ===");
            System.out.println("1. Lihat semua");
            System.out.println("2. Tambah produk");
            System.out.println("3. Update stok");
            System.out.println("4. Hapus produk");
            System.out.println("5. Cari produk");
            System.out.println("6. Sort produk");
            System.out.println("7. Filter harga");
            System.out.println("8. Simpan & Keluar");
            System.out.print("Pilih: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    viewAll(products);
                    break;
                case "2":
                    addProduct(products, sc);
                    break;
                case "3":
                    updateQuantity(products, sc);
                    break;
                case "4":
                    deleteProduct(products, sc);
                    break;
                case "5":
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String keyword = sc.nextLine();
                    List<Product> searchResults = searchProducts(products, keyword);
                    searchResults.forEach(p -> System.out.println(p.getName()));
                    break;
                case "6":
                    System.out.print("Sort by (price/quantity): ");
                    String criteria = sc.nextLine();
                    sortProducts(products, criteria);
                    break;
                case "7":
                    System.out.print("Masukkan harga minimum: ");
                    double min = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan harga maksimum: ");
                    double max = Double.parseDouble(sc.nextLine());
                    List<Product> filteredProducts = filterByPrice(products, min, max);
                    filteredProducts.forEach(p -> System.out.println(p.getName() + ": " + p.getPrice()));
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Helper untuk menampilkan semua produk
    private void viewAll(List<Product> products) {
        products.forEach(p -> System.out.println(p.getName() + ": " + p.getPrice() + " - " + p.getQuantity()));
    }

    // Helper untuk menambah produk
    private void addProduct(List<Product> products, Scanner sc) {
        System.out.println("Masukkan nama produk: ");
        String name = sc.nextLine();
        System.out.println("Masukkan kategori produk: ");
        String category = sc.nextLine();
        System.out.println("Masukkan harga produk: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Masukkan jumlah produk: ");
        int quantity = Integer.parseInt(sc.nextLine());

        int id = products.size() + 1;
        Product newProduct = new Product(id, name, category, price, quantity);
        products.add(newProduct);
        System.out.println("Produk berhasil ditambahkan!");
    }

    // Helper untuk memperbarui kuantitas produk
    private void updateQuantity(List<Product> products, Scanner sc) {
        System.out.println("Masukkan ID produk yang ingin diupdate: ");
        int id = Integer.parseInt(sc.nextLine());

        Product product = products.stream()
                                  .filter(p -> p.getId() == id)
                                  .findFirst()
                                  .orElse(null);

        if (product != null) {
            System.out.println("Masukkan kuantitas baru: ");
            int quantity = Integer.parseInt(sc.nextLine());
            product.setQuantity(quantity);
            System.out.println("Kuantitas produk berhasil diupdate!");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    // Helper untuk menghapus produk
    private void deleteProduct(List<Product> products, Scanner sc) {
        System.out.println("Masukkan ID produk yang ingin dihapus: ");
        int id = Integer.parseInt(sc.nextLine());

        Product product = products.stream()
                                  .filter(p -> p.getId() == id)
                                  .findFirst()
                                  .orElse(null);

        if (product != null) {
            products.remove(product);
            System.out.println("Produk berhasil dihapus!");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}
