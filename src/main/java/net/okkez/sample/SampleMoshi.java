package net.okkez.sample;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class SampleMoshi {

    private transient final JsonAdapter<Map<String, Object>> adapter;

    public SampleMoshi() {
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(Map.class, String.class, Object.class);
        adapter = moshi.adapter(type);
    }

    public HashMap<String, String> buildProperties(String rawProperties) throws IOException {
        Map<String, Object> map = adapter.fromJson(rawProperties);
        HashMap<String, String> properties = new HashMap<>();
        map.forEach((key, value) -> {
            if (value instanceof Double) {
                properties.put(key, Long.valueOf(((Double) value).longValue()).toString());
            } else {
                properties.put(key, value.toString());
            }
        });
        return properties;
    }
}
