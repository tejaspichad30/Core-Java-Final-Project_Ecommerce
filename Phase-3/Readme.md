
---

# 📦 E-Commerce Platform - Inventory Management System (Phase 3)

## 📌 Overview
This **Java-based Inventory Management System** allows users to manage products efficiently.  
It provides **CRUD operations**, calculates **total inventory value**, and features a **background inventory monitor using multithreading**.

## 🚀 Features & Enhancements in Phase 3

### 🔹 **1. Improved Data Structure**
✅ **Replaced `ArrayList` with `HashMap<Integer, Product>`** for faster retrieval, update, and deletion of products.  
✅ Each product **ID is unique** and acts as a key for quick lookups.

### 🔹 **2. Automatic Inventory Value Calculation (Multithreading)**
✅ Uses **a separate daemon thread** to **calculate total inventory value** automatically every **10 seconds**.  
✅ Improves efficiency by monitoring product stock changes in real-time.

### 🔹 **3. Improved Input Handling & Validation**
✅ Prevents incorrect input by **ensuring numeric entries** for **price** and **quantity**.  
✅ **Handles invalid inputs gracefully**, prompting users to enter correct values.

---

## 🏗️ **System Components**
### 📌 **1. Product Class (`Product.java`)**
Stores product details:  
✔ **ID** (Unique Identifier)  
✔ **Name**  
✔ **Category**  
✔ **Quantity**  
✔ **Price**  
✔ `displayProduct()` - Displays formatted product details.  

---

### 📌 **2. Inventory Management System (`InventoryManagementPhase3.java`)**
Manages inventory operations using a **`HashMap<Integer, Product>`**.

### **Functionalities:**
🔹 **Add Product** – Stores new product details.  
🔹 **View Products** – Displays all available products in inventory.  
🔹 **Update Product** – Allows modifying product quantity and price.  
🔹 **Delete Product** – Removes a product from inventory.  
🔹 **Calculate Total Inventory Value** – Computes total worth of inventory in stock.  
🔹 **Auto Inventory Monitor (Multithreading)** – Runs a separate thread to monitor total inventory value every **10 seconds**.

---

## 🛠️ **How to Run the Program**
1. **Compile and Run** the `InventoryManagementPhase3.java` file in any Java-supported IDE (Eclipse, IntelliJ, VS Code) or terminal.
2. The **inventory monitor thread** starts automatically and updates inventory value **every 10 seconds**.
3. **Follow the menu prompts** to manage products.

---

## 🎯 **Sample Console Output**
![image](https://github.com/user-attachments/assets/d4060718-93b1-4b64-809c-e3b1f0b4c835)


---

## 🏆 **Why Phase 3 is Better**
✅ **Faster performance** (HashMap-based storage).  
✅ **Automated inventory monitoring** using **multithreading**.  
✅ **More reliable input validation** prevents incorrect data entry.  

---

## 🚀 **Future Enhancements (Phase 4)**
🔹 **Database Integration using JDBC**  
🔹 **GUI-based Dashboard using Java Swing/JavaFX**  
🔹 **User Authentication & Role Management**  

---

## 📌 **Conclusion**
This **Java-based Inventory Management System** provides a **real-world approach** to **stock management**.  
It demonstrates **data structures, OOP principles, multithreading, and error handling** efficiently.

---


