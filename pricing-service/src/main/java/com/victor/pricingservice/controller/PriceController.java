package com.victor.pricingservice.controller;

import com.victor.pricingservice.dto.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PriceController {

    List<Price> priceList = new ArrayList<Price>();

    @GetMapping("/price/{id}")
    public Price getPriceDetails(@PathVariable Long id) {
        Price price = getPriceInfo(id);
        return price;
    }

    private Price getPriceInfo(Long id) {
        populatePriceList();
        return priceList.stream()
                .filter(productInfo -> productInfo.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    private void populatePriceList() {
        priceList.add(new Price(201L, 101L, 1999, 999));
        priceList.add(new Price(202L, 102L, 199, 19));
        priceList.add(new Price(203L, 103L, 1222, 699));
    }
}
