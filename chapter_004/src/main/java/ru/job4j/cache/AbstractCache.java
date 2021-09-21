package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/21/2021
 */
public abstract class AbstractCache<K, V> {
    //TODO Реализовать класс
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
    }

    public V get(K key) {
        return null;
    }

    protected abstract V load(K key);
}
