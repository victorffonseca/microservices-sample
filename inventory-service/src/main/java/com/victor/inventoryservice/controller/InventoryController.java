package com.victor.inventoryservice.controller;

import com.victor.inventoryservice.dto.Inventory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InventoryController {

    List<Inventory> inventoryList = new ArrayList<Inventory>();

    @GetMapping("/inventory/{id}")
    public Inventory getInventoryDetails(@PathVariable Long id) {
        Inventory inventory = getInventoryInfo(id);
        return inventory;
    }

    private Inventory getInventoryInfo(Long id) {
        populateInventoryList();
        return inventoryList.stream()
                .filter(productInfo -> productInfo.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    private void populateInventoryList() {
        inventoryList.add(new Inventory(301L, 101L, true));
        inventoryList.add(new Inventory(302L, 102L, true));
        inventoryList.add(new Inventory(303L, 103L, false));
    }
}
