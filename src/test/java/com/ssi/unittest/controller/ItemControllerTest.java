package com.ssi.unittest.controller;

import com.ssi.unittest.model.Item;
import com.ssi.unittest.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void when_callGetItem_then_receiveItem() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": \"Ball\",\n" +
                        "  \"price\": 4,\n" +
                        "  \"quantity\": 10\n" +
                        "}"))
                .andReturn();
//        JSONAssert.assertEquals("{\n" +
//                "  \"id\": 1,\n" +
//                "  \"name\": \"Ball\",\n" +
//                "  \"price\": 4,\n" +
//                "  \"quantity\": 10\n" +
//                "}", mvcResult.getResponse().getContentAsString(), Boolean.FALSE);
    }

    @Test
    public void when_callGetItemFromService_then_receiveItem() throws Exception {
        Mockito.when(itemService.getItem()).thenReturn(new Item(1, "Ball", 4, 10));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/itemFromService").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Ball,price:4,quantity:10}"))
                .andReturn();
//        JSONAssert.assertEquals("{\n" +
//                "  \"id\": 1,\n" +
//                "  \"name\": \"Apple\",\n" +
//                "  \"price\": 4,\n" +
//                "  \"quantity\": 10\n" +
//                "}", mvcResult.getResponse().getContentAsString(), Boolean.FALSE);
    }

    @Test
    public void when_callAllItem_then_getItems() throws Exception {
        Mockito.when(itemService.getAllItem())
                .thenReturn(
                        Arrays.asList(
                                new Item(1, "Ball", 4, 10),
                                new Item(1, "Bat", 10, 5)));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllItems").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{id:1,name:Ball,price:4,quantity:10}, {id:1,name:Bat,price:10,quantity:5}]"))
                .andReturn();
    }

}
