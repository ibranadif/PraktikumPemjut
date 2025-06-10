package TugasPraktikum8;

public class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalAmount = 0;
        for (Invoice invoice : invoices) {
            totalAmount += invoice.getPayableAmount();
        }
        return salaryPerMonth - totalAmount;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee: " + name + ", Registration Number: " + registrationNumber);
        System.out.println("Salary after deduction: " + getPayableAmount());
        System.out.println("Invoices:");
        for (Invoice invoice : invoices) {
            System.out.println("Product: " + invoice.getProductName() + ", Quantity: " + invoice.getQuantity() + ", Price per Item: " + invoice.getPricePerItem());
        }
    }
}
