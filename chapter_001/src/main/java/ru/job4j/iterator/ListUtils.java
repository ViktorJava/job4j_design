package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.02.2021
 */
public class ListUtils {
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

    public static <T> void addAfter(List<T> list, int index, T value) {

    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        return null;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        return null;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        return null;
    }
}
