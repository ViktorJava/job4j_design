package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тест расчёта таблицы умножения.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.03.2021
 */
public class ResultFileTest {
    /**
     * Тест таблицей умножения 2x2
     */
    @Test
    public void when2on2() {
        ResultFile matrix = new ResultFile();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }

    /**
     * Тест таблицей умножения 4x4
     */
    @Test
    public void when4on4() {
        ResultFile matrix = new ResultFile();
        int[][] table = matrix.multiple(4);
        int[][] expect = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}
        };
        assertThat(table, is(expect));
    }
}
