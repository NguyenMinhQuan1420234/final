package com.nashtech.demoqa.utils;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtil {
    public static JsonReader loadJsonfile (String nameOfJsonTestData) throws FileNotFoundException {
        String filepath = System.getProperty("DATA_PATH") + nameOfJsonTestData;
        JsonReader reader = new JsonReader(new FileReader(filepath));
        return reader;
    }
}
