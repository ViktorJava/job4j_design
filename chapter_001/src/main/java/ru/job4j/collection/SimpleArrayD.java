package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <h2>1. Динамический список на массиве [#438881]</h2>
 * Собственная реализация {@code ArrayList}.
 * <ul>Основные свойства:
 * <li>динамический {@code Capacity}
 * <li>обобщенное хранилище построено на массиве
 * </ul>
 * Итератор реализует fail-fast поведение:<p>
 * запрещено применять методы
 * {@code set()}, {@code add()}, {@code add(index)}, {@code remove()} после создания итератора.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 30.01.2021
 */
public class SimpleArrayD<T> implements Iterable<T> {
    private Object[] container;
    private static final int DEFAULT_CAPACITY = 15;
    private int size;
    private int modCount; //Счётчик изменений.

    /**
     * Этот конструктор создаёт экземпляр класса {@link SimpleArrayD}
     * заданной вместимости.
     *
     * @param initCapacity Инициализация вместимости листа.
     * @throws IllegalArgumentException Выбрасывается исключение, если
     *                                  вместимость отрицательная или равна 0.
     */
    public SimpleArrayD(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        container = new Object[initCapacity];
    }

    /**
     * Этот дефолтный конструктор создаёт экземпляр класса
     * {@link SimpleArrayD} с вместимостью 15.
     */
    public SimpleArrayD() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Добавить элемент в конец структуры данных.
     *
     * @param model Добавляемый элемент.
     */
    public void add(T model) {
        resize();
        container[size] = model;
        size++;
        modCount++; // fail-fast
    }

    /**
     * Метод добавляет элемент в хранилище согласно заданного индекса.
     *
     * @param index Индекс в хранилище.
     * @param model Добавляемый элемент.
     */
    public void add(int index, T model) {
        Objects.checkIndex(index, size + 1);
        resize();
        System.arraycopy(container, index, container, index + 1,
                size - index);
        container[index] = model;
        modCount++; // fail-fast
        size++;
    }

    /**
     * Вернуть элемент по заданному индексу. Обработать исключение
     * выхода индекса за допустимый диапазон {@link IndexOutOfBoundsException}
     *
     * @param index Индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        container[index] = model;
        modCount++; // fail-fast
    }

    /**
     * Очистка хранилища.
     */
    public void clear() {
        size = 0;
        container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Метод возвращает размер хранилища.
     *
     * @return Размер хранилища.
     */
    public int size() {
        return size;
    }

    /**
     * Проверка хранилища на пустоту.
     *
     * @return true в случае пустого хранилища, иначе false.
     */
    public boolean ifEmpty() {
        return size == 0;
    }

    /**
     * Метод возвращает первый элемент в хранилище.
     *
     * @return Первый элемент в хранилище.
     * @throws java.util.NoSuchElementException если хранилище пустое.
     */
    public T getFirst() {
        if (ifEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    /**
     * Метод возвращает последний элемент в хранилище.
     *
     * @return Метод возвращает последний элемент в хранилище.
     * @throws java.util.NoSuchElementException если хранилище пустое.
     */
    public T getLast() {
        if (ifEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    /**
     * Реализация динамики хранилища.
     */
    public void resize() {
        if (container.length == size) {
            Object[] newArray = new Object[container.length * 2];
            System.arraycopy(container, 0, newArray, 0, size);
            container = newArray; //пересетил хранилище.
        }
    }

    /**
     * Метод удаляет элемент из хранилища, согласно заданному индексу.
     * Обработать исключение выхода индекса за допустимый диапазон
     * {@link IndexOutOfBoundsException}
     *
     * @param index Индекс удаляемого элемента.
     * @return Удаляемый элемент.
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) container[index];
        System.arraycopy(container, index + 1, container, index,
                size - index - 1);
        size--;
        modCount++; // fail-fast
        return removedElement;
    }

    /**
     * Метод проверяет наличие специфического элемента в хранилище.
     *
     * @param element Элемент.
     * @return Если элемент содержится в хранилище, метод возвращает true,
     * иначе false.
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (container[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int iter;
            final int expectedModCount = modCount; // fail-fast

            @Override
            public boolean hasNext() {
                return iter < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[iter++];
            }
        };
    }
}
