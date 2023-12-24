// Implementing the concepts of strings, arrays, loops and decision making using a menu system.

package javabasics2;
import java.util.Scanner;

public class InventoryManagement {

    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class ShoppingCart {
        private int[] quantities;

        public ShoppingCart(int size) {
            this.quantities = new int[size];
        }

        public void addItem(int index, int quantity) {
            quantities[index] += quantity;
        }

        public void displayCart(Item[] items) {
            System.out.println("\nShopping Cart:");

            for (int i = 0; i < items.length; i++) {
                if (quantities[i] > 0) {
                    System.out.println(items[i].getName() + " - Quantity: " + quantities[i] + " - Total Cost: $" + (quantities[i] * items[i].getPrice()));
                }
            }
        }

        public double calculateTotalCost(Item[] items) {
            double totalCost = 0;

            for (int i = 0; i < items.length; i++) {
                totalCost += quantities[i] * items[i].getPrice();
            }

            return totalCost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize inventory items
        Item[] items = {
            new Item("Apples", 1.0),
            new Item("Bananas", 0.8),
            new Item("Bread", 2.5),
            new Item("Milk", 1.2),
            new Item("Eggs", 2.0)
        };

        ShoppingCart cart = new ShoppingCart(items.length);
        
        System.out.println("Welcome to the Grocery Store!");
        System.out.println("Available items:");

        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName() + " - $" + items[i].getPrice());
        }

        // Shopping loop with switch case
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Display cart");
            System.out.println("3. Calculate total cost");
            System.out.println("0. Finish shopping");

            //Get user choice
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	// Add item to the cart
                    System.out.print("Enter the item number to add to your cart: ");
                    int itemNumber = scanner.nextInt();

                    if (itemNumber < 1 || itemNumber > items.length) {
                        System.out.println("Invalid item number. Please try again.");
                        continue;
                    }

                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addItem(itemNumber - 1, quantity);
                    System.out.println("Added " + quantity + " " + items[itemNumber - 1].getName() + "(s) to your cart.");
                    break;

                case 2:
                	// Display shopping Cart
                    cart.displayCart(items);
                    break;

                case 3:
                	// Calculate and display the total cost
                    double totalCost = cart.calculateTotalCost(items);
                    System.out.println("\nTotal Cost: $" + totalCost);
                    break;

                case 0:
                	// Finish shopping
                    System.out.println("Thank you for shopping with us!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}