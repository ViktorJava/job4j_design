package ru.job4j.collection;

/**
 * <h2>Очередь на двух стеках [#438883]</h2>
 * Реализовать класс {@code SimpleQueue} - это очередь
 * FIFO - First Input First Output. Очередь реализованна на базе двух стеков.
 * <ul>
 * <li>Метод {@code T poll()} - должен возвращать первое значение
 * и удалять его из коллекции.</li>
 * <li>Метод {@code push(T value)} - помещает значение в конец.</li>
 * </ul>
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
     * Метод проверяет очередь на пустоту.
     *
     * @return возвращает true если очередь пуста, иначе false.
     */
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
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
