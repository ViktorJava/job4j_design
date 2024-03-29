package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ассоциативный массив на базе хэш-таблицы унифицирован через джейнерик
 * и имеет методы:
 * <pre><code class='java'>
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 * </code></pre>
 *
 * <ul>
 * <li> Реализован итератор, обладающий fail-fast поведением.</li>
 * <li> Внутренняя реализация использует массив.</li>
 * <li> Обеспечивает фиксированное время вставки и получение.</li>
 * <li> Предусмотрена возможность роста хэш-таблицы при нехватке места для нового элемента.</li>
 * <li> Методы разрешения коллизий не реализован.
 * Если, при добавлении ключа, ключ уже есть, то возвращать false.</li>
 * </ul>
 * <p>
 * {@code capacity = 1 << 4;  16}
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 17.02.2021
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    private static final float LOAD_FACTOR = 0.75F;
    private int modCount;
    private int capacity = 1 << 4;
    @SuppressWarnings("unchecked")
    private Node<K, V>[] table = new Node[capacity];
    private int size;

    /**
     * Метод, вставляет запись в таблицу по ключу и его значению.
     *
     * @param key   Ключ.
     * @param value Значение.
     * @return true в случае удачи, иначе false.
     */
    public boolean insert(K key, V value) {
        int hashCode = hash(key);
        if (table[hashCode] == null) {
            if (size >= capacity * LOAD_FACTOR) {
                expandTable();
            }
            table[hashCode] = new Node<>(key, value);
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
        int hashCode = hash(key);
        if (table[hashCode] != null && table[hashCode].getKey().equals(key)) {
            return table[hashCode].getValue();
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
        int hashCode = hash(key);
        if (table[hashCode] != null && table[hashCode].getKey().equals(key)) {
            table[hashCode] = null;
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
        int h;
        if (key == null) {
            return 0;
        } else {
            h = key.hashCode();
            return (capacity - 1) & (h ^ (h >>> 16));
        }
    }

    /**
     * Метод возвращает размер хранилища.
     *
     * @return Размер хранилища.
     */
    public int size() {
        return capacity;
    }

    /**
     * Метод возвращает первое простое число >min
     *
     * @param min Минимальное число от которого выполняется поиск простого числа.
     * @return Первое просто число >min.
     */
    private int getPrime(int min) {
        for (int j = min + 1; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }

    /**
     * Метод проверяет число n на простоту.
     *
     * @param n Проверяемое число на простоту.
     * @return true в случае простого числа, иначе false.
     */
    private boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Рост хэш-таблицы при нехватке места для вставки нового элемента.
     * Метод выполняет перехеширование.
     */
    @SuppressWarnings("unchecked")
    private void expandTable() {
        capacity = getPrime(capacity * 2);
        Node<K, V>[] tempTable = new Node[capacity];
        for (Node<K, V> node : table) {
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
