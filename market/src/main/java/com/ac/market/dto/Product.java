package com.ac.market.dto;

/**
 * Created by anupam on 1/25/17.
 */
public class Product {
    Integer productId;
    String productName;
    Double price;

    public Product() {
    }

    public Product(Integer productId, String productName, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
