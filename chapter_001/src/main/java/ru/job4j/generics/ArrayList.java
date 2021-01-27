package ru.job4j.generics;

import java.util.Objects;

/**
 * <h2>Простой ArrayList [task-0001]<h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.01.2021
 */
public class ArrayList<T> implements List<T> {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 5;
    private int size;


    /**
     * Этот конструктор создаёт экземпляр класса {@link ArrayList}
     * заданной вместимости.
     *
     * @param initCapacity инициализация вместимости листа.
     * @throws IllegalArgumentException выбрасывается исключение, если
     *                                  вместимость отрицательная или равна 0.
     */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }

    /**
     * Этот дефолтный конструктор создаёт экземпляр класса {@link ArrayList}
     * с вместимостью 5.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Добавить элемент в конец структуры данных.
     *
     * @param element добавляемый элемент.
     */
    @Override
    public void add(T element) {
        resizeIfNeeded();
        elements[size] = element;
        size++;
    }

    private void resizeIfNeeded() {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray; //пересетил хранилище.
        }
    }

    @Override
    public void add(int index, T element) {

    }

    /**
     * Вернуть элемент по заданному индексу. Обработать исключение
     * выхода индекса за допустимый диапазон {@link IndexOutOfBoundsException}
     *
     * @param index индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T first() {
        return get(0);
    }

    @Override
    public T last() {
        return get(size - 1);
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

}
