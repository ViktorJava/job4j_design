package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Элементарная структура бинарного дерева.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 26.02.2021
 */
class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод находит узел по значению parent и добавляет в него дочерний узел
     * со значением child.
     *
     * @param parent Узел которому добавляем потомка.
     * @param child  Добавляемый потомок.
     * @return true в случае удачи, иначе false.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> foundParent = findBy(parent);
        if (foundParent.isPresent() && findBy(child).isEmpty()) {
            rsl = foundParent.get().children.add(new Node<>(child));
        }
        return rsl;
    }

    /**
     * Метод поиска узла по значению. Применяется алгоритм
     * обхода дерева в ширину основанный на структуре Queue.
     *
     * @param value Значение ключа поиска.
     * @return Метод возвращает найденный узел.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
