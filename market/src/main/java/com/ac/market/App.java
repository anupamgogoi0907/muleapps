package com.ac.market;


import com.ac.market.dto.Product;
import com.ac.market.service.ProductSRV;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    @RequestMapping(path = "/app")
    class MarketController {

        @Autowired
        ProductSRV productSRV;

        @GetMapping(path = "/products")
        public String getProducts() throws Exception {
            List<Product> list = productSRV.getProducts();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            return json;
        }
    }

}
