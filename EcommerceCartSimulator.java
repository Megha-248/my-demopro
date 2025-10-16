import java.util.*;

public class EcommerceCartSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample products
        String[] products = {"Laptop", "Headphones", "Smart Watch"};
        int[] prices = {50000, 1500, 3500};
        List<String> cart = new ArrayList<>();

        System.out.println("=== E-Commerce Cart Simulator ===");

        while (true) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i] + " - ₹" + prices[i]);
            }

            System.out.println("\nChoose an option:");
            System.out.println("1. Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout and Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter product number to add: ");
                int p = sc.nextInt();
                if (p >= 1 && p <= products.length) {
                    cart.add(products[p - 1]);
                    System.out.println(products[p - 1] + " added to cart!");
                } else {
                    System.out.println("Invalid product number!");
                }
            } 
            else if (choice == 2) {
                if (cart.isEmpty()) {
                    System.out.println("Your cart is empty.");
                } else {
                    System.out.println("Items in your cart:");
                    for (String item : cart) {
                        System.out.println("- " + item);
                    }
                }
            } 
            else if (choice == 3) {
                System.out.println("\nFinal Cart Items:");
                int total = 0;
                for (String item : cart) {
                    System.out.println("- " + item);
                    for (int i = 0; i < products.length; i++) {
                        if (item.equals(products[i])) {
                            total += prices[i];
                        }
                    }
                }
                System.out.println("Total Amount: ₹" + total);
                System.out.println("Thank you for shopping!");
                break;
            } 
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
