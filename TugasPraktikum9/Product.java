package TugasPraktikum9;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    // Constructor lengkap
    public Product(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Konversi objek ke baris CSV
    public String toCsvLine() {
        return id + "," + name + "," + category + "," + price + "," + quantity;
    }

    // Buat objek Product dari satu baris CSV
    public static Product fromCsvLine(String line) {
        String[] fields = line.split(",", 5);
        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        String category = fields[2];
        double price = Double.parseDouble(fields[3]);
        int quantity = Integer.parseInt(fields[4]);
        return new Product(id, name, category, price, quantity);
    }
}
