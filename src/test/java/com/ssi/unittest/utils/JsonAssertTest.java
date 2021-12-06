package com.ssi.unittest.utils;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":4,\"quantity\":10}";

    @Test
    public void strict_match_true_test() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":4,\"quantity\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, Boolean.TRUE);
//        expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":4}";
//        JSONAssert.assertEquals(expectedResponse, actualResponse, Boolean.TRUE); // will fails
    }

    @Test
    public void strict_match_false_test() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":4,\"quantity\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, Boolean.FALSE);
        expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":4}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, Boolean.FALSE); // will pass
    }

    @Test
    public void match_without_escape_characters_test() throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:4,quantity:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, Boolean.FALSE);
    }
}
