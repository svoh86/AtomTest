package ru.home.webservice.cache;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CacheTest {
    Cache cache = new Cache();

    @Test
    public void whenPutAndGet() {
        String key = "key";
        String value = "data";
        cache.put(key, value);
        Optional<String> rsl = cache.get(key);
        assertThat(rsl).isPresent();
        assertThat(rsl.get()).isEqualTo(value);
    }

    @Test
    public void whenAlreadyPut() {
        String key = "key";
        String value = "data";
        cache.put(key, value);
        assertThat(cache.put(key, value)).isFalse();
    }
}