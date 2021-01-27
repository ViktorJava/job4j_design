package ru.job4j.generics;

/**
 * Интерфейс описывает типовую структуру данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.01.2021
 */
public interface List<T> {

    void add(T element);


    void add(int index, T element);

    T get(int index);

    T remove(int index);

    T first();

    T last();

    boolean contains(T element);

    boolean isEmpty();

    int size();

    void clear();
}
