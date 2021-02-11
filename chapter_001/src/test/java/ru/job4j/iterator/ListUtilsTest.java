package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты методов реализующих интерфейс ListIterator.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.02.2021
 */
public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 2, 2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, i -> i % 2 == 0);
        assertThat(Arrays.asList(1, 3, 5), is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, e -> e % 2 == 0, 0);
        assertThat(Arrays.asList(1, 0, 3, 0, 5, 0), is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> output = new ArrayList<>(Arrays.asList(2, 4, 6));
        ListUtils.removeAll(input, output);
        assertThat(Arrays.asList(1, 3, 5), is(input));
    }
}
