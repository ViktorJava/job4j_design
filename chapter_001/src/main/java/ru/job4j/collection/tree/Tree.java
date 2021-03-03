package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

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
     * Метод находит узел по значению parent и добавляет дочерний узел
     * со значением child.
     *
     * @param parent Значение узла-родителя которому добавляем потомка.
     * @param child  Значение добавляемого потомка.
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
     * Метод поиска элемента в дереве.
     *
     * @param value Значение разыскиваемого элемента.
     * @return Найденный узел.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findNode(el -> el.value.equals(value));
    }

    /**
     * Проверка дерева на бинарность (количество потомков >2).
     *
     * @return возвращается true, если дерево бинарное, иначе false.
     */
    public boolean isBinary() {
        return findNode(el -> (el.children.size() > 2)).isEmpty();
    }

    /**
     * Метод обхода дерева. Поиск узла по предикату. Применяется алгоритм
     * BFS (Breadth - First Search) обхода дерева в ширину
     * основанный на структуре Queue.
     *
     * @param condition Предикат поиска.
     * @return Элемент соответствующий предикату.
     */
    public Optional<Node<E>> findNode(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
