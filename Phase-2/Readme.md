# Inventory Management System - Phase 2  

This repository contains **Phase 2** of the **E-Commerce Inventory Management System**, which improves upon Phase 1 by incorporating **Object-Oriented Programming (OOP) concepts** such as **Encapsulation** and **ArrayLists** for dynamic data storage.  

---

## **Features Implemented in Phase 2**  
✅ Object-Oriented Approach (Encapsulation using classes)  
✅ Dynamic Data Storage using `ArrayList` instead of fixed-size arrays  
✅ Auto-incrementing **Product ID**  
✅ Improved **Input Validation** for numbers and prices  
✅ CRUD operations (**Add, View, Update, Delete Products**)  
✅ **Total Inventory Value Calculation**  

---

## **Technologies Used**  
- **Java** (Core Java, OOP)  
- **ArrayList** (for dynamic inventory management)  
- **Scanner Class** (for user input)  

---

## **Classes Used**  

### 1️⃣ **`Product` Class**  
This class represents a **single product** in the inventory. It contains:  
- **Attributes**: `id`, `name`, `category`, `quantity`, `price`  
- **Getters and Setters** (Encapsulation)  
- **Method**: `displayProduct()` – Displays product details  


---

### 2️⃣ **`InventoryManagementPhase2` Class**  
This class **manages the inventory** and handles all operations.  

#### **Methods Used**  

| Method Name         | Function |
|---------------------|----------|
| `run()`            | Displays the menu and handles user input |
| `addProduct()`     | Adds a new product to the inventory |
| `viewProducts()`   | Displays the list of products |
| `updateProduct()`  | Updates product details |
| `deleteProduct()`  | Removes a product from inventory |
| `totalInventoryValue()` | Calculates total inventory value |
| `getValidInt()`    | Validates integer input |
| `getValidDouble()` | Validates decimal input |
| `findProductById()` | Finds a product using its ID |


---

## **How to Run the Program**  
1️⃣ Clone the repository  
```sh
git clone https://github.com/your-username/E-Commerce-Inventory-Phase2.git
```

2️⃣ Open the project in **Eclipse/IntelliJ IDEA/VS Code**  

3️⃣ Run the `InventoryManagementPhase2.java` file  

---

## **Sample Console Output**  

```
![image](https://github.com/user-attachments/assets/6dac4e24-f066-496f-9f69-b8f4d0d901f9)

---

## **Future Enhancements (Phase 3)**  
🔹 Implement **Database Integration** using **JDBC**  
🔹 Introduce **Multithreading** for concurrent operations  
🔹 Add **Graphical User Interface (GUI)** using **Java Swing/JavaFX**  

---


🚀 **Happy Coding!** 🚀
