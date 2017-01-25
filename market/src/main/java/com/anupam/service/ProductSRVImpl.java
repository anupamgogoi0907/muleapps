package com.anupam.service;

import com.anupam.utility.MyUtility;
import com.anupam.utility.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by anupam on 1/25/17.
 */

@Service
public class ProductSRVImpl implements ProductSRV {
    private Map<String, List<Product>> mapWallmarty = null;
    private Map<String, List<Product>> mapAmazona = null;

    @PostConstruct
    public void init() {
        mapWallmarty = MyUtility.createDummyProductWallmarty();
        mapAmazona = MyUtility.createDummyProductAmazona();
    }

    @Override
    public List<Product> getWallmartyProducts(String type) {
        return mapWallmarty.get(type);
    }

    @Override
    public List<Product> getAmazonaProducts(String type) {
        return mapAmazona.get(type);
    }
}
