package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

/**
 * <h2>Реализовать коллекцию Set на массиве [#438906]</h2>
 * Реализовать коллекцию {@code SimpleSet}. Коллекция должна обеспечивать:
 * <li>{@code boolean add(E e)} и реализовывать {@code Iterable<E>}.
 * <li>Коллекция не должна хранить дубликаты.
 * <li>Написать тесты на наличие дубликатов
 * <li>Написать тест с учетом {@code null} элемента.
 * <li>Какой метод класса {@code Objects} можно использовать в этой задаче.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.02.2021
 */
class SimpleSet<T> implements Iterable<T> {
    private final SimpleArrayD<T> repository = new SimpleArrayD<>();

    /**
     * Метод добавляет элемент в множество включая null, при этом исключая дубликаты.
     *
     * @param e Добавляемый элемент.
     * @return true в случае удачного добавления, иначе false.
     */
    public boolean add(T e) {
        if (!contains(e)) {
            repository.add(e);
            return true;
        }
        return false;
    }

    /**
     * Валидация на дубликаты, вынесена в отдельный метод по причине fail-fast
     * итератора.
     *
     * @param e Элемент проверяемый на наличие дубликата в хранилище.
     * @return true в случае наличия дубликата в хранилище, иначе false.
     */
    private boolean contains(T e) {
        for (T element: repository) {
            if (Objects.equals(e, element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return repository.iterator();
    }
}
