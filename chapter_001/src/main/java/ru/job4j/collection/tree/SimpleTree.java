package ru.job4j.collection.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс описывающий бинарное дерево.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 26.02.2021
 */
public interface SimpleTree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    /**
     * Nested class описывает узел дерева.
     *
     * @param <E> Тип узла дерева.
     */
    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
