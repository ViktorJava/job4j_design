package ru.job4j.collection.map;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тесты класса SimpleHashMap.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 17.02.2021
 */
@Ignore
public class SimpleHashMapTest {
    @Test
    public void whenInsert() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        assertThat(simpleHashMap.insert(1, "first"), is(true));
    }

    @Test
    public void whenGet() {

    }

    @Test
    public void whenDelete() {

    }
}