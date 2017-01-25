package com.anupam.service;

import com.anupam.utility.Product;

import java.util.List;

/**
 * Created by anupam on 1/25/17.
 */
public interface ProductSRV {

    public List<Product> getWallmartyProducts(String type);

    public List<Product> getAmazonaProducts(String type);
}
