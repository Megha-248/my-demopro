package com.example.demo.controller;
import com.example.demo.model.CartItem;  // CartItem class in model package
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private List<CartItem> cart = new ArrayList<>();

    // ------------------ Add to Cart ------------------
    @PostMapping("/add")
    public String addToCart(@RequestBody CartItem item) {
        boolean found = false;

        for (CartItem c : cart) {
            if (c.getProductId() == item.getProductId()) {
                // Update quantity if already in cart
                c.setQty(c.getQty() + item.getQty());
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(item.getProductId(), item.getName(), item.getPrice(), item.getQty(), item.getImg()));
        }

        return "Product added to cart!";
    }

    // ------------------ Remove from Cart ------------------
    @PostMapping("/remove")
    public String removeFromCart(@RequestBody CartItem item) {
        cart.removeIf(c -> c.getProductId() == item.getProductId());
        return "Product removed from cart!";
    }

    // ------------------ Get Cart Items ------------------
    @GetMapping
    public List<CartItem> getCart() {
        return cart;
    }

    // ------------------ Clear Cart (Checkout) ------------------
    @PostMapping("/clear")
    public String clearCart() {
        cart.clear();
        return "Cart cleared successfully!";
    }
}
