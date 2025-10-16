package com.example.demo.model;

public class CartItem {
    private int productId;
    private String name;
    private double price;
    private int qty;
    private String img;

    public CartItem() {}

    public CartItem(int productId, String name, double price, int qty, String img) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.img = img;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
}
