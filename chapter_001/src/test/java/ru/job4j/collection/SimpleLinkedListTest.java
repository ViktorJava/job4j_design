package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    @Ignore
    public void whenAdd() {
        simpleLinkedList.add(10);
        Integer expected = simpleLinkedList.get(0);
        assertThat(expected, is(10));
    }
}
