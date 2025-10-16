package com.example.demo.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.*;
import com.example.demo.model.Product;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(1, "Xbox Matt One Controller", "Gaming Devices", "/images/1.png", 49.99, "Xbox", "Gaming", "Blue", "-50%", 50));
        products.add(new Product(2, "Car Air Purifier", "Electronics", "/images/2.png", 19.99, "AutoAir", "Electronics", "Blue", "0%", 10));
        products.add(new Product(3, "JBL Wireless Headphones", "Electronics", "/images/3.png", 71.69, "JBL", "Electronics", "Blue", "0%", 15));
        products.add(new Product(4, "Polaroid Snap Touch", "Instant Cameras", "/images/4.png", 99.89, "Polaroid", "Cameras", "Blue", "0%", 5));
        products.add(new Product(5, "Apple mini Smart Speaker", "Smart Watches", "/images/5.png", 98.69, "Apple", "Smart Watches", "Blue", "0%", 12));
        products.add(new Product(6, "Apple iPhone 13 Pro", "Phones", "/images/6.png", 999.99, "Apple", "Phones", "Blue", "Special", 20));
        products.add(new Product(7, "Samsung Galaxy S21", "Phones", "/images/7.png", 899.99, "Samsung", "Phones", "Black", "0%", 18));
        products.add(new Product(8, "Sony PlayStation 5", "Gaming Devices", "/images/8.png", 499.99, "Sony", "Gaming", "White", "-10%", 25));
        products.add(new Product(9, "HP Pavilion Laptop", "Computers", "/images/9.png", 799.99, "HP", "Computers", "Silver", "0%", 12));
        products.add(new Product(10, "Dell Inspiron Laptop", "Computers", "/images/10.png", 699.99, "Dell", "Computers", "Gray", "0%", 15));
        products.add(new Product(11, "Logitech Wireless Mouse", "Accessories", "/images/11.png", 29.99, "Logitech", "Accessories", "Black", "0%", 50));
        products.add(new Product(12, "Canon EOS M50", "Cameras", "/images/12.png", 599.99, "Canon", "Cameras", "Black", "0%", 8));
        products.add(new Product(13, "Apple AirPods Pro", "Electronics", "/images/13.png", 249.99, "Apple", "Electronics", "White", "0%", 20));
        products.add(new Product(14, "Fitbit Charge 5", "Smart Watches", "/images/14.png", 149.99, "Fitbit", "Smart Watches", "Black", "0%", 25));
        products.add(new Product(15, "Samsung Galaxy Watch 5", "Smart Watches", "/images/15.png", 299.99, "Samsung", "Smart Watches", "Silver", "0%", 15));
        products.add(new Product(16, "Nintendo Switch", "Gaming Devices", "/images/16.png", 349.99, "Nintendo", "Gaming", "Red", "0%", 18));
        products.add(new Product(17, "Google Nest Hub", "Smart Home", "/images/17.png", 99.99, "Google", "Smart Home", "White", "0%", 10));
        products.add(new Product(18, "Amazon Echo Dot", "Smart Home", "/images/18.png", 49.99, "Amazon", "Smart Home", "Black", "0%", 22));
        products.add(new Product(19, "Anker Power Bank 20000mAh", "Accessories", "/images/19.png", 39.99, "Anker", "Accessories", "Black", "0%", 30));
        products.add(new Product(20, "GoPro HERO 9", "Cameras", "/images/20.png", 399.99, "GoPro", "Cameras", "Black", "0%", 10));
        products.add(new Product(21, "Sony WH-1000XM4 Headphones", "Electronics", "/images/21.png", 349.99, "Sony", "Electronics", "Black", "0%", 15));
        products.add(new Product(22, "MacBook Air M1", "Computers", "/images/22.png", 999.99, "Apple", "Computers", "Silver", "0%", 12));
        products.add(new Product(23, "Microsoft Surface Pro 8", "Computers", "/images/23.png", 1099.99, "Microsoft", "Computers", "Gray", "0%", 8));
        products.add(new Product(24, "Razer BlackWidow Keyboard", "Accessories", "/images/24.png", 129.99, "Razer", "Accessories", "Black", "0%", 20));
        products.add(new Product(25, "Samsung Galaxy Buds 2", "Electronics", "/images/25.png", 149.99, "Samsung", "Electronics", "White", "0%", 25));
        products.add(new Product(26, "DJI Mini 3 Drone", "Drones", "/images/26.png", 459.99, "DJI", "Drones", "White", "0%", 10));
        products.add(new Product(27, "Kindle Paperwhite", "Electronics", "/images/27.png", 129.99, "Amazon", "Electronics", "Black", "0%", 30));
        products.add(new Product(28, "Apple Watch Series 8", "Smart Watches", "/images/28.png", 399.99, "Apple", "Smart Watches", "Silver", "0%", 18));
        products.add(new Product(29, "HP Omen Gaming Laptop", "Computers", "/images/29.png", 1199.99, "HP", "Computers", "Black", "-15%", 7));
        products.add(new Product(30, "Logitech C920 Webcam", "Accessories", "/images/30.png", 69.99, "Logitech", "Accessories", "Black", "0%", 20));
        products.add(new Product(31, "Sony Alpha a6400", "Cameras", "/images/31.png", 899.99, "Sony", "Cameras", "Black", "0%", 5));
        products.add(new Product(32, "Nintendo Switch OLED", "Gaming Devices", "/images/32.png", 349.99, "Nintendo", "Gaming", "White", "0%", 12));
        products.add(new Product(33, "Samsung Smart TV 55\"", "Electronics", "/images/33.png", 699.99, "Samsung", "Electronics", "Black", "0%", 10));
        products.add(new Product(34, "Apple iPad Air", "Tablets", "/images/34.png", 599.99, "Apple", "Tablets", "Silver", "0%", 15));
        products.add(new Product(35, "Bose SoundLink Speaker", "Electronics", "/images/35.png", 199.99, "Bose", "Electronics", "Black", "0%", 20));
        products.add(new Product(36, "Garmin Forerunner 245", "Smart Watches", "/images/36.png", 249.99, "Garmin", "Smart Watches", "Black", "0%", 12));
        products.add(new Product(37, "Samsung Galaxy Tab S7", "Tablets", "/images/37.png", 649.99, "Samsung", "Tablets", "Black", "0%", 10));
        products.add(new Product(38, "Roku Streaming Stick+", "Electronics", "/images/38.png", 49.99, "Roku", "Electronics", "Black", "0%", 30));
        products.add(new Product(39, "Alienware Aurora Gaming PC", "Computers", "/images/39.png", 1499.99, "Dell", "Computers", "Black", "0%", 5));
        products.add(new Product(40, "Apple HomePod Mini", "Smart Home", "/images/40.png", 99.99, "Apple", "Smart Home", "White", "0%", 25));
    }

    public List<Product> all() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }
}
