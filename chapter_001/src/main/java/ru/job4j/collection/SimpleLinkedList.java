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
 * <p>
 * private int modCount; //fail-fast поведение.
 * @since 01.02.2021
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int modCount;
    private int size;

    /**
     * Метод проверяет контейнер на пустоту.
     *
     * @return true если контейнер пустой, иначе false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Метод добавляет элемент данных в конец списка.
     *
     * @param value Добавляемый элемент в хранилище.
     */
    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        modCount++;
        size++;
    }

    /**
     * Метод возвращает элемент данных по заданному индексу.
     *
     * @param index Индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     * @throws IndexOutOfBoundsException Бросается исключение при выходе индекса
     *                                   за допустимый диапазон.
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }
        return current.value;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * С целью прикручивания структуры данных к циклу типа forEach,
     * реализуется интерфейс {@link Iterable}.
     * Возвращается итератор бегущий по элементам данных, типа {@code <E>}.
     *
     * @return Возвращаемый итератор.
     * @throws ConcurrentModificationException нарушение fail-fast поведения.
     * @throws NoSuchElementException          обращение у несуществующему элементу.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<E> pointer = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return pointer != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }
}
