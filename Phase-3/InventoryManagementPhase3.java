package E_Commerce_Platform_phase3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(int id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public void displayProduct() {
        System.out.printf("%d | %s | %s | %d | %.2f\n", id, name, category, quantity, price);
    }
}

public class InventoryManagementPhase3 {
    private final Map<Integer, Product> inventory = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public static void main(String[] args) {
        InventoryManagementPhase3 system = new InventoryManagementPhase3();
        
        Thread inventoryMonitor = new Thread(system::autoCalculateInventoryValue);
        inventoryMonitor.setDaemon(true);
        inventoryMonitor.start();

        system.run();
    }

    public void autoCalculateInventoryValue() {
        while (true) {
            try {
                Thread.sleep(10000);
                if (!inventory.isEmpty()) {
                    totalInventoryValue();
                }
            } catch (InterruptedException e) {
                System.out.println("Inventory monitor interrupted!");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Inventory Management System (Phase 3) ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Total Inventory Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

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

    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine().trim(); // Read input properly

        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();

        int quantity = getValidInt("Enter quantity: ");
        double price = getValidDouble("Enter price: ");

        Product product = new Product(nextId, name, category, quantity, price);
        inventory.put(nextId++, product);
        System.out.println("Product added successfully!");
    }

    public void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("\nID | Name | Category | Quantity | Price");
        for (Product product : inventory.values()) {
            product.displayProduct();
        }
    }

    public void updateProduct() {
        viewProducts();
        if (inventory.isEmpty()) return;

        int id = getValidInt("Enter Product ID to update: ");
        if (!inventory.containsKey(id)) {
            System.out.println("Product not found!");
            return;
        }

        Product product = inventory.get(id);

        int quantity = getValidInt("Enter new quantity: ");
        double price = getValidDouble("Enter new price: ");

        product.setQuantity(quantity);
        product.setPrice(price);
        System.out.println("Product updated successfully!");
    }

    public void deleteProduct() {
        viewProducts();
        if (inventory.isEmpty()) return;

        int id = getValidInt("Enter Product ID to delete: ");
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void totalInventoryValue() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        double totalValue = inventory.values().stream()
            .mapToDouble(p -> p.getQuantity() * p.getPrice())
            .sum();

        System.out.println("Total Inventory Value: Rs." + totalValue);
    }

    private int getValidInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return value;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private double getValidDouble(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return value;
            } else {
                System.out.println("Invalid input! Please enter a valid price.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
