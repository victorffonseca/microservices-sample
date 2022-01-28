package com.victor.productservice.controller;

import com.victor.productservice.dto.Inventory;
import com.victor.productservice.dto.Price;
import com.victor.productservice.dto.Product;
import com.victor.productservice.dto.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    List<ProductInfo> productList = new ArrayList<ProductInfo>();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product/details/{id}")
    public Product getProductDetails(@PathVariable Long id) {
        ProductInfo productInfo = getProductInfo(id);

        Price price = restTemplate.getForObject("http://localhost:8002/price/" + id, Price.class);
        Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/" + id, Inventory.class);

        return new Product(productInfo.getId(), productInfo.getName(), productInfo.getDescription(), price.getDiscountedPrice(), inventory.getInStock());
    }

    private ProductInfo getProductInfo(Long id) {
        populateProductList();
        return productList.stream()
                .filter(productInfo -> productInfo.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    private void populateProductList() {
        productList.add(new ProductInfo(101L, "iPhone", "iPhone is expensive"));
        productList.add(new ProductInfo(102L, "Book", "Book is great"));
        productList.add(new ProductInfo(103L, "Washing MC", "Washing MC is necessary"));
    }
}
