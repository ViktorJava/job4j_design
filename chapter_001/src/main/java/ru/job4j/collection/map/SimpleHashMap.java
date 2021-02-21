package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ассоциативный массив на базе хэш-таблицы унифицирован через джейнерик
 * и иметь методы:
 * <pre>
 * {@code boolean insert(K key, V value);}
 * {@code V get(K key)};
 * {@code boolean delete(K key);}
 * </pre>
 * <li> Реализован итератор, обладающий fail-fast поведением.
 * <li> Внутренняя реализация использует массив.
 * <li> Обеспечивает фиксированное время вставки и получение.
 * <li> Предусмотрена возможность роста хэш-таблицы при нехватке места для нового элемента.
 * <li> Методы разрешения коллизий не реализован. Если, при добавлении,
 * ключ уже есть, то возвращать false.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 17.02.2021
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    private int modCount;
    private int capacity = 16;
    @SuppressWarnings("unchecked")
    private Node<K, V>[] table = new Node[capacity];
    private int size;
    private static final float LOAD_FACTOR = 0.75F;


    /**
     * Метод, вставляет запись в таблицу по ключу и его значению.
     *
     * @param key   Ключ.
     * @param value Значение.
     * @return true в случае удачи, иначе false.
     */
    public boolean insert(K key, V value) {
        if (table[hash(key)] == null) {
            if (size >= capacity * LOAD_FACTOR) {
                expandTable();
            }
            table[hash(key)] = new Node<>(key, value);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает значение заданного ключа.
     *
     * @param key Ключ
     * @return Значение.
     */
    public V get(K key) {
        if (table[hash(key)] != null && table[hash(key)].getKey().equals(key)) {
            return table[hash(key)].getValue();
        }
        throw new NoSuchElementException();
    }

    /**
     * Метод удаляет значение по ключу.
     *
     * @param key Ключ.
     * @return true в случае удачи, иначе false.
     */
    public boolean delete(K key) {
        if (table[hash(key)] != null && table[hash(key)].getKey().equals(key)) {
            table[hash(key)] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * Метод расчёта и сжатия хэш-кода ключа.
     *
     * @param key Ключ.
     * @return Индекс бакета.
     */
    private int hash(K key) {
        return key == null ? 0 : key.hashCode() % capacity;
    }

    public int size() {
        return capacity;
    }

    /**
     * Рост хэш-таблицы при нехватке места для вставки нового элемента.
     */
    @SuppressWarnings("unchecked")
    private void expandTable() {
        capacity *= 2;
        Node<K, V>[] tempTable = new Node[capacity];
        for (Node<K, V> node: table) {
            if (node != null) {
                tempTable[hash(node.getKey())] = node;
            }
        }
        table = tempTable;
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
                return index < size;
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
