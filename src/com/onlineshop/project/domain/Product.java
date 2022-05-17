package com.onlineshop.project.domain;

public class Product {
    private int id;
    private String title;
    private int availableProducts;
    private int price;

    private int addToCart;
    private int removeFromCart;
    private int productInCart;

    public int getProductInCart() {
        return productInCart;
    }

    public int getAddToCart() {
        return addToCart;
    }

    // ba add to cart va remove va product in cart sync konam!
    public void setAdd(int addToCart) {

        if (this.availableProducts != 0)
            this.availableProducts = availableProducts - 1;

        if (addToCart == 5)
            this.addToCart = addToCart;
        else
            this.addToCart = addToCart + 1;
    }

    public int getRemoveFromCart() {
        return removeFromCart;
    }

    public void setRemove(int removeFromCart) {
        this.availableProducts = availableProducts + 1;
        if (removeFromCart == 0)
            this.removeFromCart = removeFromCart;
        else
            this.removeFromCart = removeFromCart - 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(int availableProducts) {
        this.availableProducts = availableProducts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
