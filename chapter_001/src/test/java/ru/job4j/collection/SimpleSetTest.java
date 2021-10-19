package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Тесты множества.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.02.2021
 */
public class SimpleSetTest {

    @Test
    public void whenAddDublicates() {
        SimpleSet<String> input = new SimpleSet<>();
        input.add("one");
        Iterator<String> i = input.iterator();
        assertThat(i.next(), is("one"));
        assertThat(input.add("one"), is(false));
    }

    @Test
    public void whenAddNull() {
        SimpleSet<String> input = new SimpleSet<>();
        input.add("one");
        input.add(null);
        Iterator<String> i = input.iterator();
        assertThat(i.next(), is("one"));
        assertThat(i.next(), nullValue());
    }
}
