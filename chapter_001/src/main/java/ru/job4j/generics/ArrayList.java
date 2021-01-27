package ru.job4j.generics;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.01.2021
 */
public class ArrayList<T> implements List<T> {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 5;


    /**
     * Этот конструктор создаёт экземпляр класса {@link ArrayList}
     * заданного размера.
     *
     * @param initCapacity инициализация размера листа.
     * @throws IllegalArgumentException - если размер отрицательный или равен 0.
     */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }

    /**
     * Этот дефолтный конструктор создаёт экземпляр класса {@link ArrayList}
     * с размером по умолчанию 5.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T element) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
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
        return 0;
    }

    @Override
    public void clear() {

    }
}
