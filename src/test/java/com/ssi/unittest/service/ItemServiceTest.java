package com.ssi.unittest.service;

import com.ssi.unittest.model.Item;
import com.ssi.unittest.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void when_callGetAllItemWithSomeBusinessLogic_then_getItems(){
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "Alphabets", 20, 3)));
        List<Item> items = itemService.getAllItem();
        Assertions.assertEquals(60, items.get(0).getValue());
    }

}
