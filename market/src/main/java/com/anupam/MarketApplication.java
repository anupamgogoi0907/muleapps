package com.anupam;

import com.anupam.service.ProductSRV;
import com.anupam.utility.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@SpringBootApplication
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

    @RestController
    @RequestMapping(path = "/")
    class MarketController {

        @Autowired
        ProductSRV productSRV;

        @GetMapping(path = "/wallmarty")
        public String getWallmarty(@PathParam(value = "type") String type) throws Exception {
            List<Product> list = productSRV.getWallmartyProducts(type);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            return json;
        }

        @GetMapping(path = "/amazona")
        public String getAmazona(@PathParam(value = "type") String type) throws Exception {
            List<Product> list = productSRV.getAmazonaProducts(type);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(list);
            return json;
        }


    }

}
