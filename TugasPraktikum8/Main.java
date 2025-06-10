package TugasPraktikum8;

public class Main {
    public static void main(String[] args) {
        Invoice invoice1 = new Invoice("Laptop", 1, 10000000);
        Invoice invoice2 = new Invoice("Printer", 2, 250000);
        Invoice invoice3 = new Invoice("Meja Kantor", 1, 1500000);

        Invoice[] invoices = {invoice1, invoice2, invoice3};

        Employee employee = new Employee(12345, "John Doe", 15000000, invoices);

        employee.displayEmployeeInfo();
    }
}
