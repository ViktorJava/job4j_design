package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <h2>Удалить head в односвязном списке. [#438878]</h2>
 * Необходимо реализовать методы delete для односвязного списка.
 * <li>{@code T deleteFirst()}
 * <li>{@code T deleteLast()}
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @implNote В методах {@code delete} должна быть проверка, что {@code head != null}.
 * Этот случай проверяется в тесте.
 * @since 03.02.2021
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * Метод добавляет элемент данных в конец списка.
     *
     * @param value Добавляемый элемент в хранилище.
     */
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (isEmpty()) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Удаление первого элемента в цепочке данных.
     * По другому, это называется, обнуление ссылки на следующий узел.
     *
     * @return Удалённый элемент
     * @throws NoSuchElementException Исключение бросается при попытке
     *                                удалить несуществующий элемент.
     */
    public T deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = head.value;
        head = head.next;
        return result;
    }

    /**
     * Метод проверяет односвязный список на пустоту.
     *
     * @return true если список пустой, иначе false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Метод удаляет элемент данных в конце списка.<p>
     * {@code head = null; //удаление последнего оставшегося элемента в списке.}<p>
     * {@code previous.next = null; //обрыв связи предыдущего с последующим элементом.}
     *
     * @return Значение удалённого элемента.
     * @throws NoSuchElementException Бросается исключение в случае отсутствия
     *                                элементов в списке.
     */
    public T deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        Node<T> previous = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (current == previous) {
            head = null;
        }
        previous.next = null;
        return current.value;
    }

    /**
     * Метод обращение односвязного списка.
     */
    public void revert() {
        if (isEmpty()) {
            return;
        }
        Node<T> current = head;
        Node<T> previous = head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * С целью прикручивания структуры данных к циклу типа forEach,
     * реализуется интерфейс {@link Iterable}.
     * Возвращается итератор бегущий по элементам данных, типа {@code <T>}.
     *
     * @return Возвращаемый итератор.
     * @throws NoSuchElementException обращение к несуществующему элементу.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}
