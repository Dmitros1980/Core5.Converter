package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class CreateJSON {
    private String text;
    private String fileName;

    public static String listToJson(List<Employee> list) {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        System.out.println(gson.toJson(list, listType));
        return gson.toJson(list, listType);
    }

    static void writeString(String text, String fileName) {
        try (FileWriter file = new
                FileWriter(fileName)) {
            file.write(text);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
