package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <h2>Итератор для двухмерного массива int[][] [#438891]</h2>
 * Написать для двумерного массива, итератор, который
 * последовательно вернет элементы.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.01.2021
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int col = 0;
    private int row = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    /**
     * Метод проверяет, есть ли следующий элемент.
     *
     * @return true в случае наличия следующего элемента, иначе false.
     */
    @Override
    public boolean hasNext() {
        //если есть строка но строка пустая {{},{}} двигаемся на следующую строку.
        while (row < data.length && data[row].length == 0) {
            row++;
        }
        //true если есть строка и в строке есть столбцы
        return (row < data.length && col < data[row].length);
    }

    /**
     * Метод смещает указатель и возвращает следующий элемент
     * двумерного массива.
     *
     * @return Следующий элемент двумерного массива.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][col++];

        if (col >= data[row].length) {
            row++;
            col = 0;
        }
        return result;
    }
}
