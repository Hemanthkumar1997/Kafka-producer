package com.kafka.producer.utils;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {
    public MapBuilder(){
        this.map = new HashMap<>();
    }

    private Map<K, V> map;

    public MapBuilder<K, V> put(K key, V value) {
        this.map.put(key, value);
        return this;
    }

    public Map<K, V> get() {
        return this.map;
    }
}
