package ru.job4j.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <h2>FlatMap для Iterator<Iterator> [#438889]</h2>
 * В Stream API есть метод flatMap.
 * Он позволяет получить из элемента потока другой поток.
 * Необходимо создать подобное поведение.
 * Класс FlatMap принимает объект вложенных итераторов.
 * В классе нужно реализовать два метода: {@code next()} и {@code hasNext()}.
 * Метод {@code next()} должен последовательно вернуть
 * числа из вложенных итераторов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.01.2021
 */
public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
        this.cursor = Collections.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        while (!cursor.hasNext() && data.hasNext()) {
            this.cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String... args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.print(flat.next() + " ");
        }
    }
}
