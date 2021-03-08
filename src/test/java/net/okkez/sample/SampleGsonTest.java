package net.okkez.sample;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SampleGsonTest {

    @Test
    void buildProperties() {
        SampleGson o = new SampleGson();
        HashMap<String, String> result = o.buildProperties("{\"push_enabled\": true}");
        assertEquals("true", result.get("push_enabled"));
        HashMap<String, String> result2 = o.buildProperties("{}");
        assert(result2.isEmpty());
        HashMap<String, String> result3 = o.buildProperties("{\"product_id\": 999}");
        assertEquals("999", result3.get("product_id"));
    }
}