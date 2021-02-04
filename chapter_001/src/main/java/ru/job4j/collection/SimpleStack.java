package ru.job4j.collection;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.02.2021
 */
public class SimpleStack<T> {
    private ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    /**
     * Метод удаляет элемент из коллекции и возвращает его значение.
     *
     * @return Возвращаемое значение.
     */
    public T pop() {
        return forwardLinked.deleteLast();
    }

    /**
     * Метод помещает значение в коллекцию.
     *
     * @param value Значение помещаемое в коллекцию.
     */
    public void push(T value) {
        forwardLinked.add(value);
    }
}
