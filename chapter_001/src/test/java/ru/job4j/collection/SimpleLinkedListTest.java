package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты класса SimpleLinkedList.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 01.02.2021
 */
public class SimpleLinkedListTest {
    SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();

    @Test
    public void whenAddIntoEmptyList() {
        simpleLinkedList.add(10);
        simpleLinkedList.add(20);
        Integer expected = simpleLinkedList.get(1);
        assertThat(expected, is(20));
    }

    @Test
    public void whenEmpty() {
        simpleLinkedList.add(10);
        assertThat(simpleLinkedList.isEmpty(), is(false));
    }

    @Test
    public void whenIsEmptyOnEmptyList() {
        assertThat(simpleLinkedList.isEmpty(), is(true));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenFailFastException() {
        simpleLinkedList.add(10);
        Iterator<Integer> iterator = simpleLinkedList.iterator();
        simpleLinkedList.add(10);
        iterator.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        simpleLinkedList.add(10);
        assertThat(simpleLinkedList.get(1), is(0));
    }
}
