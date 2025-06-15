package org.example.core.renderer;

public interface SaveHandler {
    void saveObj(String id, Object obj);

    <T> T loadObj(String id, Class<T> clazz);
}
