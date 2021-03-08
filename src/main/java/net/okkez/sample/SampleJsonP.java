package net.okkez.sample;

import javax.json.*;
import java.io.StringReader;
import java.util.HashMap;

public class SampleJsonP {

    public HashMap<String, String> buildProperties(String rawProperties) {
        JsonReader jsonReader = Json.createReader(new StringReader(rawProperties));
        JsonObject o = jsonReader.readObject();
        HashMap<String, String> properties = new HashMap<>();
        o.forEach((key, value) -> {
            properties.put(key, value.toString());
        });
        return properties;
    }
}
