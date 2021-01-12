package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <h2>5.1.2. Создать итератор четные числа [#438888]</h2>
 * Создать итератор возвращающий только четные цифры.
 * Итератор должен принимать список произвольных чисел.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 05.01.2021
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int pointer = -1;
    private int nextPointer = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    /**
     * Метод, проверяет, есть ли следующий чётный элемент.
     *
     * @return true в случае наличия следующего элемента, иначе false.
     */
    @Override
    public boolean hasNext() {
        return pointer != findIndex();
    }

    /**
     * Метод, смещает указатель и возвращает следующий чётный элемент.
     *
     * @return Следующий чётный элемент.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        pointer = nextPointer;
        return data[pointer];
    }

    /**
     * Поиск чётного элемента в массиве данных, целочисленного типа.
     *
     * @return Индекс нового чётного элемента в случае его наличия.
     */
    public int findIndex() {
        for (int i = pointer + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                nextPointer = i;
                break;
            }
        }
        return nextPointer;
    }
}
