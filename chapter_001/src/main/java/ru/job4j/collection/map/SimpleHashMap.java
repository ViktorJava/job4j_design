package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ассоциативный массив на базе хэш-таблицы унифицирован через генерики
 * и иметь методы:
 * <li>{@code boolean insert(K key, V value);}
 * <li>{@code V get(K key)};
 * <li>{@code boolean delete(K key);}
 * Реализован итератор, обладающий fail-fast поведением.
 * Внутренняя реализация использует массив.
 * Обеспечивает фиксированное время вставки и получение.
 * Предусмотрена возможность роста хэш-таблицы при нехватке места для нового элемента.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 17.02.2021
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    private int modCount = 0;
    private int capacity = 16;
    private Node<K, V>[] table = new Node[capacity];

    /**
     * Метод, вставляет запись в таблицу по ключу и его значению.
     *
     * @param key   Ключ.
     * @param value Значение.
     * @return true в случае удачи, иначе false.
     */
    boolean insert(K key, V value) {
        return false;
    }

    /**
     * Метод возвращает значение заданного ключа.
     *
     * @param key Ключ
     * @return Значение.
     */
    public V get(K key) {
        if (table[hash(key)] != null && table[hash(key)] == key) {
            return table[hash(key)].getValue();
        }
        throw new NoSuchElementException();
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    /**
     * Метод удаляет значение по ключу.
     *
     * @param key Ключ.
     * @return true в случае удачи, иначе false.
     */
    boolean delete(K key) {
        return false;
    }

    /**
     * Static nested class.
     *
     * @param <K> Ключ.
     * @param <V> Значение ключа.
     */
    private static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < capacity;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[index] == null) {
                    index++;
                }
                return table[index++].getValue();
            }
        };
    }
}
