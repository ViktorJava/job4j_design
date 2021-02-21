package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();

    @Test
    public void whenInsert() {
        assertThat(simpleHashMap.insert("one", 1), is(true));
        assertThat(simpleHashMap.insert("two", 2), is(true));
        assertThat(simpleHashMap.insert("two", 2), is(false));
    }

    @Test
    public void whenGet() {
        simpleHashMap.insert("first", 1);
        assertThat(simpleHashMap.get("first"), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenFailFastException() {
        simpleHashMap.insert("one", 1);
        Iterator<Integer> iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is(1));
        simpleHashMap.insert("two", 2);
        assertThat(iterator.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHasNextException() {
        simpleHashMap.insert("one", 1);
        Iterator<Integer> iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void whenDeleteReturnFalse() {
        simpleHashMap.insert("one", 1);
        assertThat(simpleHashMap.delete("one"), is(true));
        assertThat(simpleHashMap.delete("two"), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNotKey() {
        simpleHashMap.insert("one", 1);
        assertThat(simpleHashMap.get("one"), is(1));
        assertThat(simpleHashMap.get("two"), is(2));
    }

    @Test
    public void whenExpandTable() {
        SimpleHashMap<Integer, Integer> input = new SimpleHashMap<>();
        for (int i = 0; i < 13; i++) {    // capacity * 0.75
            input.insert(i, i);
        }
        assertThat(input.size(), is(32));
    }
}
