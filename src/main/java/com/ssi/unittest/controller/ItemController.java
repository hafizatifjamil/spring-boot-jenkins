package com.ssi.unittest.controller;

import com.ssi.unittest.model.Item;
import com.ssi.unittest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "Ball", 4, 10);
    }

    @GetMapping("/itemFromService")
    public Item getItemFromService() {
        return itemService.getItem();
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }
}
