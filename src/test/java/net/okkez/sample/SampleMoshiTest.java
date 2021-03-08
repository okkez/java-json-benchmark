package net.okkez.sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SampleMoshiTest {

    @Test
    void buildProperties() throws IOException {
        SampleMoshi o = new SampleMoshi();
        Map<String, String> result = o.buildProperties("{\"push_enabled\": true}");
        assertEquals("true", result.get("push_enabled"));
        Map<String, String> result2 = o.buildProperties("{}");
        assert(result2.isEmpty());
        Map<String, String> result3 = o.buildProperties("{\"product_id\": 999}");
        assertEquals("999", result3.get("product_id"));
    }
}