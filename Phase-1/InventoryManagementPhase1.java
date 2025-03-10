package E_Commarce_platform;

import java.util.Scanner;

public class InventoryManagementPhase1 {
    static final int MAX_PRODUCTS = 100; // Maximum number of products in the inventory

    // Arrays to store product details
    static String[] names = new String[MAX_PRODUCTS];
    static String[] categories = new String[MAX_PRODUCTS];
    static int[] quantities = new int[MAX_PRODUCTS];
    static double[] prices = new double[MAX_PRODUCTS];
    static int productCount = 0; // Track the number of products

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu-driven approach using a loop
        do {
            System.out.println("\n=== Inventory Management System (Basic) ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Total Inventory Value");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            // Validate user input (must be an integer)
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Perform action based on user choice
                switch (choice) {
                    case 1: addProduct(scanner); break;
                    case 2: viewProducts(); break;
                    case 3: updateProduct(scanner); break;
                    case 4: deleteProduct(scanner); break;
                    case 5: totalInventoryValue(); break;
                    case 6: System.out.println("Exiting... Thank you!"); break;
                    default: System.out.println("Invalid choice! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                choice = 0;
            }
        } while (choice != 6); // Repeat until user chooses to exit

        scanner.close(); // Close scanner to prevent resource leak
    }

    // Method to add a new product
    public static void addProduct(Scanner scanner) {
        if (productCount >= MAX_PRODUCTS) {
            System.out.println("Inventory is full! Cannot add more products.");
            return;
        }

        System.out.print("Enter product name: ");
        names[productCount] = scanner.nextLine();

        System.out.print("Enter category: ");
        categories[productCount] = scanner.nextLine();

        // Validate quantity input (must be an integer)
        System.out.print("Enter quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Enter a valid quantity.");
            scanner.next(); // Clear invalid input
        }
        quantities[productCount] = scanner.nextInt();

        // Validate price input (must be a decimal/number)
        System.out.print("Enter price: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Enter a valid price.");
            scanner.next(); // Clear invalid input
        }
        prices[productCount] = scanner.nextDouble();

        productCount++; // Increase product count
        System.out.println("Product added successfully!");
    }

    // Method to display all products
    public static void viewProducts() {
        if (productCount == 0) {
            System.out.println("No products in inventory.");
            return;
        }

        // Display product list in table format
        System.out.println("\nID | Name | Category | Quantity | Price");
        for (int i = 0; i < productCount; i++) {
            System.out.printf("%d | %s | %s | %d | %.2f\n", 
                              i + 1, names[i], categories[i], quantities[i], prices[i]);
        }
    }

    // Method to update product details
    public static void updateProduct(Scanner scanner) {
        viewProducts(); // Show available products before update
        if (productCount == 0) return;

        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Validate Product ID
        if (id < 1 || id > productCount) {
            System.out.println("Invalid Product ID!");
            return;
        }

        int index = id - 1; // Convert ID to array index

        // Get new details from user
        System.out.print("Enter new name: ");
        names[index] = scanner.nextLine();

        System.out.print("Enter new category: ");
        categories[index] = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        quantities[index] = scanner.nextInt();

        System.out.print("Enter new price: ");
        prices[index] = scanner.nextDouble();

        System.out.println("Product updated successfully!");
    }

    // Method to delete a product
    public static void deleteProduct(Scanner scanner) {
        viewProducts(); // Show available products before deletion
        if (productCount == 0) return;

        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();

        // Validate Product ID
        if (id < 1 || id > productCount) {
            System.out.println("Invalid Product ID!");
            return;
        }

        int index = id - 1; // Convert ID to array index

        // Shift all products after the deleted product to the left
        for (int i = index; i < productCount - 1; i++) {
            names[i] = names[i + 1];
            categories[i] = categories[i + 1];
            quantities[i] = quantities[i + 1];
            prices[i] = prices[i + 1];
        }

        productCount--; // Reduce product count
        System.out.println("Product deleted successfully!");
    }

    // Method to calculate total inventory value
    public static void totalInventoryValue() {
        if (productCount == 0) {
            System.out.println("No products in inventory.");
            return;
        }

        double totalValue = 0;
        // Calculate total value of all products
        for (int i = 0; i < productCount; i++) {
            totalValue += quantities[i] * prices[i];
        }

        System.out.println("Total Inventory Value: Rs." + totalValue);
    }
}
	
