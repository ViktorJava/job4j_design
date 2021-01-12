package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <h2>Что такое итератор. [#438890]</h2>
 * Итератор для одномерного массива чисел. Итератор отдаёт элементы
 * в обратном порядке.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 03.01.2021
 */
public class ArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    /**
     * Метод проверяет, если ли следующий элемент.
     *
     * @return true в случае наличия следующего элемента, иначе false.
     */
    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    /**
     * Метод сдвигает указатель итератора в обратном порядке
     * и возвращает значение.
     *
     * @return Элемент ячейки.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
