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

    public void put(String key, String data) {
        cache.putIfAbsent(key, data);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(cache.get(key));
    }
}
