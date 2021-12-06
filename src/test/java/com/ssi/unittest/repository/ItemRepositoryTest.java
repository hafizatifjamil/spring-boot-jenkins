package com.ssi.unittest.repository;

import com.ssi.unittest.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findAllItemsTest(){
        List<Item> items = itemRepository.findAll();
        Assertions.assertEquals(6, items.size());
    }
}
