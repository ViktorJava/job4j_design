package ru.job4j.collection.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты проверки корректности открытых и закрытых скобок.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/22/2021
 */
public class ParenthesesTest {
    @Test
    public void whenValidInner() {
        assertThat(
                Parentheses.valid(new char[]{'(', '(', ')', ')'}),
                is(true)
        );
    }

    @Test
    public void whenValidSeq() {
        assertThat(
                Parentheses.valid(new char[]{'(', ')', '(', ')'}),
                is(true)
        );
    }

    @Test
    public void whenValid() {
        assertThat(
                Parentheses.valid(new char[]{'(', 'a', '(', 'b', ')', ')'}),
                is(true)
        );
    }

    @Test
    public void whenInValidInner() {
        assertThat(
                Parentheses.valid(new char[]{')', ')', '(', '('}),
                is(false)
        );
    }

    @Test
    public void whenInValidSeq() {
        assertThat(
                Parentheses.valid(new char[]{'(', ')', '(', '('}),
                is(false)
        );
    }
}
