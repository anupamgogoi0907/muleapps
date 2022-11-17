package com.ac.market.service;


import com.ac.market.dto.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anupam on 1/25/17.
 */

@Service
public class ProductSRVImpl implements ProductSRV {
    private List<Product> productList = null;

    @PostConstruct
    public void init() {
        productList = Arrays.asList(new Product(1, "iPhone", 5000.0),
                new Product(1, "Mac Book", 6000.0),
                new Product(1, "iPad", 1000.0),
                new Product(1, "iPod", 200.0));

    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }
}
