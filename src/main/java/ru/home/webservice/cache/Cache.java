package ru.home.webservice.cache;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
public final class Cache {
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    public boolean put(String key, String data) {
       return cache.putIfAbsent(key, data) == null;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(cache.get(key));
    }
}
