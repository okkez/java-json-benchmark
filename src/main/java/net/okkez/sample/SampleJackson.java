package net.okkez.sample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class SampleJackson {

    private final transient ObjectMapper mapper = new ObjectMapper();
    private final transient TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() {};

    public HashMap<String, String> buildProperties(String rawProperties) throws IOException {
        HashMap<String, String> properties = mapper.readValue(rawProperties, typeReference);
        return properties;
    }
}
