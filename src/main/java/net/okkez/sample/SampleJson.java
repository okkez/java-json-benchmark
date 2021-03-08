package net.okkez.sample;

import org.json.JSONObject;

import java.util.HashMap;

public class SampleJson {

    public HashMap<String, String> buildProperties(String rawProperties) {
        JSONObject o = new JSONObject(rawProperties);
        HashMap<String, String> properties = new HashMap<>();
        for (String key : o.keySet()) {
            properties.put(key, o.get(key).toString());
        }
        return properties;
    }
}
