package org.example.core.renderer;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class JsonHandler implements SaveHandler {
    private final Gson gson = new Gson();
    private final String storageDir = "data/"; // Directory to store JSON files

    public JsonHandler() {
        File dir = new File(storageDir);
        if (!dir.exists()) {
            dir.mkdirs();  // Create directory if needed
        }
    }

    @Override
    public void saveObj(String id, Object obj) {
        String jsonStr = gson.toJson(obj);
        String filePath = storageDir + id + ".json";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace(); // Handle appropriately in production code
        }
    }
    @Override
    public <T> T loadObj(String id, Class<T> clazz) {
        String filePath = storageDir + id + ".json";

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace(); // Handle appropriately in production code
            return null;
        }
    }
}

