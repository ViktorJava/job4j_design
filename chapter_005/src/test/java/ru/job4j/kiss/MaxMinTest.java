package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Поиск максимального объекта в списке.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10/20/2021
 */
public class MaxMinTest {
    private List<Integer> list;

    @Before
    public void ini() {
        list = List.of(1, 2, 3, 4);
    }

    @Test
    public void max() {
        Integer expected = 4;
        Integer result = new MaxMin().max(list, Integer::compareTo);
        assertThat(result, is(expected));
    }

    @Test
    public void min() {
        Integer expected = 1;
        Integer result = new MaxMin().min(list, Integer::compareTo);
        assertThat(result, is(expected));
    }
}
