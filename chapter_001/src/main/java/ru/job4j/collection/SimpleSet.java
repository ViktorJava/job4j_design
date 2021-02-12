package ru.job4j.collection;

import java.util.Iterator;

/**
 * <h2>Реализовать коллекцию Set на массиве [#438906]</h2>
 * 1. Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать
 * boolean add(E e) и реализовывать Iterable<E>. Коллекция не должна хранить дубликаты.
 * 2. Написать тесты на наличие дубликатов
 * 3. Написать тест с учетом null элемента. Подумайте какой метод класса
 * Objects можно использовать в этой задаче
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.02.2021
 */
class SimpleSet<T> implements Iterable<T> {
    private final SimpleArrayD<T> repository = new SimpleArrayD<>();

    public boolean add(T e) {
        return false;
    }

    public int size() {
        return repository.size();
    }

    @Override
    public Iterator<T> iterator() {
        return repository.iterator();
    }
}
