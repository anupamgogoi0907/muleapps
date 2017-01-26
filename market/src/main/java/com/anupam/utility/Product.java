package com.anupam.utility;

import java.util.Date;

/**
 * Created by anupam on 1/25/17.
 */
public class Product {
    Integer productId;
    String productName;
    String productType;
    String brand;
    Double price;

    String manufacturer;
    String originLocation;
    String manufactureDate;


    public Product() {
    }

    public Product(Integer productId, String productName, String productType, String brand, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.brand = brand;
        this.price = price;
    }

    public Product(Integer productId, String productName, String productType, String brand, Double price, String manufacturer, String originLocation, String manufactureDate) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.brand = brand;
        this.price = price;
        this.manufacturer = manufacturer;
        this.originLocation = originLocation;
        this.manufactureDate = manufactureDate;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
