package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <h2>Создать контейнер на базе связанного списка [#438882]</h2>
 * Необходимо создать динамический контейнер с методами:
 * <li>{@code add(E value)}; (добавляет в конец)
 * <li>{@code E get(int index)};
 * <li>реализовать интерфейс {@code Iterable<E>}.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @implNote Внутри контейнер должен базироваться на связанном списке
 * {@code Node<E> node}. Использовать стандартные коллекции JDK
 * {@code ArrayList, LinkedList} и т.д. запрещено. Контейнер должен быть
 * динамическим, т.е. увеличиваться по мере добавления элементов.
 * Итератор должен реализовывать fail-fast поведение, т.е. если с момента
 * создания итератора коллекция подверглась структурному изменению, итератор
 * должен кидать {@code ConcurrentModificationException}.
 * В методах, где используется индекс нужно делать валидацию.
 * @since 01.02.2021
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private int modCount;
    private int size;

    /**
     * Метод возвращает элемент хранилища по заданному индексу.
     *
     * @param index Индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     */
    public E get(int index) {
        Objects.checkIndex(index, size);

        return null;
    }

    /**
     * Метод добавляет элемент в хранилище.
     *
     * @param value Добавляемый элемент в хранилище имеющий тип {@code <E>}
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value, null);
        newLink.next = first;
        first = newLink;
        modCount++;
        size++;
    }

    /**
     * Возвращает итератор по элементам типа {@code <E>}.
     *
     * @return Возвращаемый итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private final Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return null;
            }
        };
    }

    private static class Node<E> {
        E value; // данные
        Node<E> next; // следующий элемент в списке

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
