package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

/**
 * <h2>ListIterator [#438880]</h2>
 * Практическое применение интерфейса
 * {@code ListIterator} и его {@code fail-safe} поведения.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.02.2021
 */
public class ListUtils {
    /**
     * Метод вставляет список элементов после заданного индекса;
     *
     * @param list  Список элементов.
     * @param index Индекс вставки.
     * @param value Значение вставляемого элемента.
     * @param <T>   Тип элементов в списке.
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Метод вставляет элемент до заданного индекса;
     *
     * @param list  Список элементов.
     * @param index Индекс вставки.
     * @param value Значение вставляемого элемента.
     * @param <T>   Тип элементов в списке.
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.previousIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Метод удаляет все элементы, которые удовлетворяют предикату.
     *
     * @param list   Список элементов.
     * @param filter Функциональный интерфейс {@link Predicate}.
     * @param <T>    Тип элементов в списке.
     * @return Список элементов обработанный предикатом.
     */
    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while ((i.hasNext())) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
        return list;
    }

    /**
     * Метод заменяет все элементы, которые удовлетворяют предикату;
     *
     * @param list   Список элементов.
     * @param filter Функциональный интерфейс {@link Predicate}.
     * @param value  Значение вставляемого элемента.
     * @param <T>    Тип элементов в списке.
     * @return Список элементов обработанный предикатом.
     */
    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
        return list;
    }

    /**
     * Метод удаляет из списка те элементы, которые есть в elements.
     *
     * @param list     Список элементов.
     * @param elements Список удаляемых элементов.
     * @param <T>      Тип элементов в списках.
     * @return Результатный список элементов.
     */
    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (elements.contains(i.next())) {
                i.remove();
            }
        }
        return list;
    }
}
