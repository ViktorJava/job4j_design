package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.02.2021
 */
public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<Integer> input = new SimpleSet<>();
        input.add(1);
        input.add(2);
        assertThat(input.size(), is(2));
    }
}
