package ru.job4j.collection;

/**
 * <h2>Очередь на двух стеках [#438883]</h2>
 * Реализовать класс {@code SimpleQueue} это очередь.
 * Метод {@code poll()} - должен возвращать первое значение и удалять его из коллекции.
 * Метод {@code push(T value)} - помещает значение в конец.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.02.2021
 */
public class SimpleQueue<T> {
    SimpleStack<T> in = new SimpleStack<>();
    SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод должен возвращать первое значение и удалять его из коллекции.
     *
     * @return Первое значение.
     */
    public T poll() {
        return null;
    }

    /**
     * Метод помещает значение в конец.
     *
     * @param value Помещаемое значение.
     */
    public void push(T value) {
    }
}
