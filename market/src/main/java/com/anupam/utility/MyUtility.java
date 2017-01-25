package com.anupam.utility;

import java.util.*;

/**
 * Created by anupam on 1/25/17.
 */
public class MyUtility {

    public static Map<String, List<Product>> createDummyProductWallmarty() {
        Map<String, List<Product>> map = new HashMap<>();

        List<Product> productList = new ArrayList<>();

        // IPhone
        for (int i = 1; i < 10; i++) {
            Product product = new Product(i, i % 2 == 0 ? "IPhone5" : "IPhone6", "Mobile Phone", "Apple", 185.50 + new Random().nextInt(10), "Apple", "USA", new Date());
            productList.add(product);
        }
        map.put("iphone", productList);

        // Mac
        productList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Product product = new Product(i, i % 2 == 0 ? "Mac" : "Mac Pro", "Mobile Phone", "Apple", 400.0 + new Random().nextInt(10), "Apple", "USA", new Date());
            productList.add(product);
        }
        map.put("macbook", productList);
        return map;

    }

    public static Map<String, List<Product>> createDummyProductAmazona() {
        Map<String, List<Product>> map = new HashMap<>();

        List<Product> productList = new ArrayList<>();

        // IPhone
        for (int i = 1; i < 10; i++) {
            Product product = new Product(i, i % 3 == 0 ? "IPhone5" : "IPhone6", "Mobile Phone", "Apple", 185.50 + new Random().nextInt(10));
            productList.add(product);
        }
        map.put("iphone", productList);

        // Mac
        for (int i = 1; i < 10; i++) {
            Product product = new Product(i, i % 3 == 0 ? "Mac Pro" : "IPhone6", "Mobile Phone", "Apple", 450.0 + new Random().nextInt(10));
            productList.add(product);
        }
        map.put("macbook", productList);
        return map;
    }
}
