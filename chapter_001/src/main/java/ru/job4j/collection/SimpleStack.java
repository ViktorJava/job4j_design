package ru.job4j.collection;

/**
 * <h2>Используя контейнер на базе связанного списка создать контейнер Stack [#438879]</h2>
 * <li>{@code Stack} - примитивная структура данных.
 * <li>{@code Stack} лучше всего реализовать на базе связанного списка.
 * <li>Связанный список умеет быстро вставлять данные и удалять.
 * <li>Это как раз те действия, которые нужны для {@code Stack}.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.2
 * @since 04.02.2021
 */
public class SimpleStack<T> {
    private final ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    /**
     * Метод удаляет элемент из стека и возвращает его значение.
     *
     * @return Возвращаемое значение.
     */
    public T pop() {
        return forwardLinked.deleteLast();
    }

    /**
     * Метод помещает значение в стек.
     *
     * @param value Значение помещаемое в стек.
     */
    public void push(T value) {
        forwardLinked.add(value);
    }

    /**
     * Метод проверяет стек на пустоту.
     *
     * @return true если стек пустой, иначе false.
     */
    public boolean isEmpty() {
        return forwardLinked.isEmpty();
    }
}
