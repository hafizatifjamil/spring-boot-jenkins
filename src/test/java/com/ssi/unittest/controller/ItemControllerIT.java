package com.ssi.unittest.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
        String response = this.testRestTemplate.getForObject("/hello", String.class);
        Assertions.assertEquals("Hello World", response);
    }

    @Test
    public void when_callGetAllItems_then_returnItems() throws JSONException {
        String response = this.testRestTemplate.getForObject("/getAllItems", String.class);
        JSONAssert.assertEquals("[{id:1000},{id:1001},{id:1002},{id:1003},{id:1004},{id:1006}]", response, Boolean.FALSE);
    }

}
