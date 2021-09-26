package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный кэш.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/21/2021
 */
public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * Метод отправляет данные в кэш.
     *
     * @param key   Ключ данных в кэше.
     * @param value Данные отправляемые в кэш.
     */
    public void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        cache.put(key, softReference);
    }

    /**
     * Метод получения данных из кэша.
     * Если в кэше нет данных, подгружаются.
     *
     * @param key Ключ получения данных из кэша.
     * @return Данные полученные из кэша.
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public V get(K key) {
        if (!cache.containsKey(key)) {
            System.out.printf("ключа %s нет в кэше %n", key);
            V value = load(key);
            put(key, value);
            System.out.printf("кэшируем ключ %s%n", key);
        }
        System.out.printf("читаем ключ %s из кэша %n", key);
        V result = cache.get(key).get(); //корректная работа с softReference.
        return result;
    }

    /**
     * Абстрактный метод загрузки данных по ключу.
     *
     * @param key Ключ данных типа K.
     * @return Данные типа V.
     */
    protected abstract V load(K key);
}
