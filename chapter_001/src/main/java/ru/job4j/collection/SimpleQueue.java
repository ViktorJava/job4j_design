package ru.job4j.collection;

/**
 * <h2>Очередь на двух стеках [#438883]</h2>
 * Реализовать класс {@code SimpleQueue} - это очередь
 * FIFO - First Input First Output. Очередь реализованна на базе двух стеков.
 * <li>Метод {@code T poll()} - должен возвращать первое значение
 * и удалять его из коллекции.
 * <li>Метод {@code push(T value)} - помещает значение в конец.
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
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Метод помещает значение в конец очереди.
     *
     * @param value Помещаемое значение в очередь.
     */
    public void push(T value) {
        in.push(value);
    }
}
