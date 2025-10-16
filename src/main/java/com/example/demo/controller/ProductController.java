package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1, "Red Dress", "Fashionable Red Dress", "/images/red-dress.jpg", 1200, "Zara", "Clothing", "Red", "-10%", 10));
        products.add(new Product(2, "Blue Jeans", "Comfortable Blue Jeans", "/images/blue-jeans.jpg", 1500, "Levis", "Clothing", "Blue", "-15%", 8));
        products.add(new Product(3, "White T-Shirt", "Casual White T-Shirt", "/images/white-tshirt.jpg", 700, "H&M", "Clothing", "White", "-5%", 20));
        products.add(new Product(4, "Black Sneakers", "Sporty Black Sneakers", "/images/black-sneakers.jpg", 2500, "Nike", "Footwear", "Black", "-20%", 5));
        products.add(new Product(5, "Brown Sandals", "Summer Brown Sandals", "/images/brown-sandals.jpg", 1800, "Bata", "Footwear", "Brown", "-10%", 12));
        products.add(new Product(6, "Leather Boots", "Premium Leather Boots", "/images/leather-boots.jpg", 3200, "Clarks", "Footwear", "Black", "-15%", 7));
        products.add(new Product(7, "Headphones", "Noise-Cancelling Headphones", "/images/headphones.jpg", 2800, "Sony", "Electronics", "Black", "-5%", 15));
        products.add(new Product(8, "Smartwatch", "Fitness Smartwatch", "/images/smartwatch.jpg", 5500, "Apple", "Electronics", "Silver", "-10%", 6));
        products.add(new Product(9, "Mobile Phone", "Latest Android Smartphone", "/images/phone.jpg", 15000, "Samsung", "Electronics", "Black", "-8%", 10));
        products.add(new Product(10, "Sunglasses", "UV Protection Sunglasses", "/images/sunglasses.jpg", 1200, "Ray-Ban", "Accessories", "Black", "-12%", 18));
        products.add(new Product(11, "Leather Wallet", "Genuine Leather Wallet", "/images/wallet.jpg", 900, "Fossil", "Accessories", "Brown", "-10%", 25));
        products.add(new Product(12, "Analog Watch", "Classic Analog Watch", "/images/watch.jpg", 2000, "Titan", "Accessories", "Silver", "-5%", 14));
        products.add(new Product(13, "Ceramic Mug", "Coffee Ceramic Mug", "/images/mug.jpg", 400, "HomeMate", "Kitchenware", "White", "-15%", 30));
        products.add(new Product(14, "Table Lamp", "Decorative Table Lamp", "/images/lamp.jpg", 1500, "Philips", "Home Decor", "Yellow", "-10%", 8));
        products.add(new Product(15, "Decorative Pillow", "Soft Decorative Pillow", "/images/pillow.jpg", 800, "Ikea", "Home Decor", "Red", "-12%", 20));
        products.add(new Product(16, "Blue Shirt", "Formal Blue Shirt", "/images/blue-shirt.jpg", 1100, "Arrow", "Clothing", "Blue", "-5%", 15));
        products.add(new Product(17, "Grey Hoodie", "Casual Grey Hoodie", "/images/grey-hoodie.jpg", 1800, "Puma", "Clothing", "Grey", "-10%", 10));
        products.add(new Product(18, "Running Shoes", "Lightweight Running Shoes", "/images/running-shoes.jpg", 2600, "Adidas", "Footwear", "Blue", "-15%", 6));
        products.add(new Product(19, "Flip Flops", "Comfortable Flip Flops", "/images/flipflops.jpg", 600, "Nike", "Footwear", "Black", "-5%", 25));
        products.add(new Product(20, "Wireless Earbuds", "Bluetooth Wireless Earbuds", "/images/earbuds.jpg", 3200, "JBL", "Electronics", "White", "-10%", 12));
        products.add(new Product(21, "Gaming Mouse", "Ergonomic Gaming Mouse", "/images/gaming-mouse.jpg", 1800, "Logitech", "Electronics", "Black", "-8%", 15));
        products.add(new Product(22, "Mechanical Keyboard", "RGB Mechanical Keyboard", "/images/keyboard.jpg", 3500, "Corsair", "Electronics", "Black", "-10%", 10));
        products.add(new Product(23, "Laptop Stand", "Adjustable Laptop Stand", "/images/laptop-stand.jpg", 1200, "AmazonBasics", "Accessories", "Silver", "-5%", 20));
        products.add(new Product(24, "Backpack", "Travel Backpack", "/images/backpack.jpg", 2000, "Wildcraft", "Accessories", "Black", "-12%", 14));
        products.add(new Product(25, "Travel Bag", "Stylish Travel Bag", "/images/travel-bag.jpg", 2800, "Skybags", "Accessories", "Brown", "-15%", 8));
        products.add(new Product(26, "Coffee Maker", "Automatic Coffee Maker", "/images/coffee-maker.jpg", 3200, "Philips", "Kitchenware", "Black", "-10%", 5));
        products.add(new Product(27, "Water Bottle", "Reusable Water Bottle", "/images/water-bottle.jpg", 500, "Milton", "Kitchenware", "Blue", "-5%", 30));
        products.add(new Product(28, "Yoga Mat", "Non-Slip Yoga Mat", "/images/yoga-mat.jpg", 800, "Nike", "Fitness", "Purple", "-10%", 12));
        products.add(new Product(29, "Sports Cap", "Adjustable Sports Cap", "/images/sports-cap.jpg", 400, "Adidas", "Accessories", "Black", "-5%", 20));
        products.add(new Product(30, "Denim Jacket", "Classic Denim Jacket", "/images/denim-jacket.jpg", 2500, "Levis", "Clothing", "Blue", "-12%", 6));
        products.add(new Product(31, "Black Belt", "Leather Black Belt", "/images/black-belt.jpg", 700, "Titan", "Accessories", "Black", "-8%", 25));
        products.add(new Product(32, "Earrings Set", "Golden Earrings Set", "/images/earrings.jpg", 900, "Zara", "Accessories", "Gold", "-10%", 18));
        products.add(new Product(33, "Necklace", "Fashion Necklace", "/images/necklace.jpg", 1500, "H&M", "Accessories", "Silver", "-12%", 12));
        products.add(new Product(34, "Bracelet", "Stylish Bracelet", "/images/bracelet.jpg", 1200, "Fossil", "Accessories", "Gold", "-5%", 10));
        products.add(new Product(35, "Wall Clock", "Modern Wall Clock", "/images/wall-clock.jpg", 1800, "Ajanta", "Home Decor", "White", "-10%", 7));
        products.add(new Product(36, "Floor Rug", "Comfortable Floor Rug", "/images/floor-rug.jpg", 2500, "Ikea", "Home Decor", "Red", "-15%", 6));
        products.add(new Product(37, "Cushion Cover", "Soft Cushion Cover", "/images/cushion-cover.jpg", 400, "HomeMate", "Home Decor", "Blue", "-5%", 25));
        products.add(new Product(38, "Desk Organizer", "Wooden Desk Organizer", "/images/desk-organizer.jpg", 800, "Ikea", "Home Decor", "Brown", "-8%", 15));
        products.add(new Product(39, "Bluetooth Speaker", "Portable Bluetooth Speaker", "/images/bluetooth-speaker.jpg", 3000, "JBL", "Electronics", "Black", "-10%", 12));
        products.add(new Product(40, "Laptop Bag", "Stylish Laptop Bag", "/images/laptop-bag.jpg", 3500, "Wildcraft", "Accessories", "Black", "-12%", 10));
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return products;
    }
}
