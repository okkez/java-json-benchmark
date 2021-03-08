package net.okkez.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;


public class SampleGson {

    private final transient Gson gson = new GsonBuilder().serializeNulls().create();
    private final transient Type x = new TypeToken<HashMap<String,String>>(){}.getType();

    public HashMap<String,String> buildProperties(String rawProperties) {
        HashMap<String, String> properties = gson.fromJson(rawProperties, x);
        return properties;
    }
}
