package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты класса SimpleHashMap.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 17.02.2021
 */
public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();

    @Test
    public void whenInsert() {
        assertThat(simpleHashMap.insert(1, "one"), is(true));
        assertThat(simpleHashMap.insert(2, "two"), is(true));
        assertThat(simpleHashMap.insert(1, "two"), is(false));
    }

    @Test
    public void whenGet() {
        simpleHashMap.insert(1, "first");
        assertThat(simpleHashMap.get(1), is("first"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenFailFastException() {
        simpleHashMap.insert(1, "one");
        Iterator<String> iterator = simpleHashMap.iterator();
        simpleHashMap.insert(2, "two");
        assertThat(iterator.next(), is("one"));
    }

    @Test
    public void whenDelete() {
        simpleHashMap.insert(1, "one");
        simpleHashMap.insert(2, "two");
        assertThat(simpleHashMap.delete(1), is(true));
        assertThat(simpleHashMap.delete(2), is(true));
    }
}
