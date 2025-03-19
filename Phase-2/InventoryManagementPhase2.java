package E_Commerce_Platform_phase2;

import java.util.ArrayList;
import java.util.Scanner;

// Product class represents an inventory item
class Product {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    // Constructor
    public Product(int id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Display product details
    public void displayProduct() {
        System.out.printf("%d | %s | %s | %d | %.2f\n", id, name, category, quantity, price);
    }
}

// Inventory Management System Class
public class InventoryManagementPhase2 {
    private ArrayList<Product> inventory = new ArrayList<>(); // Stores list of products
    private Scanner scanner = new Scanner(System.in);
    private int nextId = 1; // Auto-incrementing product ID

    public static void main(String[] args) {
        InventoryManagementPhase2 system = new InventoryManagementPhase2();
        system.run();
    }

    // Main menu loop
    public void run() {
        int choice;
        do {
            System.out.println("\n=== Inventory Management System (OOP) ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Total Inventory Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1: addProduct(); break;
                    case 2: viewProducts(); break;
                    case 3: updateProduct(); break;
                    case 4: deleteProduct(); break;
                    case 5: totalInventoryValue(); break;
                    case 6: System.out.println("Exiting... Thank you!"); break;
                    default: System.out.println("Invalid choice! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                choice = 0;
            }
        } while (choice != 6);
    }

    // Method to add a new product
    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        int quantity = getValidInt("Enter quantity: ");
        double price = getValidDouble("Enter price: ");

        // Create new product and add to inventory
        Product product = new Product(nextId++, name, category, quantity, price);
        inventory.add(product);
        System.out.println("Product added successfully!");
    }

    // Method to display all products
    public void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("\nID | Name | Category | Quantity | Price");
        for (Product product : inventory) {
            product.displayProduct();
        }
    }

    // Method to update product details
    public void updateProduct() {
        viewProducts(); // Show available products before updating
        if (inventory.isEmpty()) return;

        int id = getValidInt("Enter Product ID to update: ");
        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Invalid Product ID!");
            return;
        }

        System.out.print("Enter new name: ");
        product.setName(scanner.nextLine());

        System.out.print("Enter new category: ");
        product.setCategory(scanner.nextLine());

        product.setQuantity(getValidInt("Enter new quantity: "));
        product.setPrice(getValidDouble("Enter new price: "));

        System.out.println("Product updated successfully!");
    }

    // Method to delete a product
    public void deleteProduct() {
        viewProducts(); // Show available products before deleting
        if (inventory.isEmpty()) return;

        int id = getValidInt("Enter Product ID to delete: ");
        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Invalid Product ID!");
            return;
        }

        inventory.remove(product);
        System.out.println("Product deleted successfully!");
    }

    // Method to calculate total inventory value
    public void totalInventoryValue() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        double totalValue = 0;
        for (Product product : inventory) {
            totalValue += product.getQuantity() * product.getPrice();
        }

        System.out.printf("Total Inventory Value: Rs. %.2f\n", totalValue);
    }

    // Method to validate integer input
    private int getValidInt(String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (value > 0) return value;
                else System.out.println("Value must be greater than 0.");
            } else {
                System.out.println("Invalid input! Enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Method to validate double input
    private double getValidDouble(String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (value > 0) return value;
                else System.out.println("Value must be greater than 0.");
            } else {
                System.out.println("Invalid input! Enter a valid price.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Method to find a product by ID
    private Product findProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
