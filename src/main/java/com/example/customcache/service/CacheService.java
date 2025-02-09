package com.example.customcache.service;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CacheService implements Serializable {
    private static final long serialVersionUID = 1L; // Added serialVersionUID

    private final int MAX_CACHE_SIZE = 10;
    private final Map<String, String> cache;

    public CacheService() {
        this.cache = new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
            private static final long serialVersionUID = 1L; // Added serialVersionUID inside LinkedHashMap

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized String put(String key, String value) {
        if (cache.size() >= MAX_CACHE_SIZE) {
            return "Cache is full! Cannot add more items.";
        }
        cache.put(key, value);
        return "Key-Value pair added successfully.";
    }

    public synchronized String get(String key) {
        return cache.getOrDefault(key, "Key not found");
    }

    public synchronized String delete(String key) {
        return (cache.remove(key) != null) ? "Key deleted successfully." : "Key not found.";
    }
}
