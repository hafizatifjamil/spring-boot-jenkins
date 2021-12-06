package com.ssi.unittest.service;

import com.ssi.unittest.model.Item;
import com.ssi.unittest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getItem(){
        return new Item(1, "Apple", 4, 10);
    }

    public List<Item> getAllItem(){
        List<Item> items = itemRepository.findAll();
        for(Item item: items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

    public long getItemsCount(){
        return itemRepository.count();
    }
}
