package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты итератора одномерного массива, отдающего элементы в обратном порядке.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 03.01.2021
 */
public class ArrayItTest {
    @Test
    public void whenMultiCallhasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    /**
     * Тест валидации итератора.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(new int[]{});
        it.next();
    }
}
