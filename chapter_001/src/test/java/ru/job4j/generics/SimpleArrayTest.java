package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты универсальной обертки над массивом.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 22.01.2021
 */
public class SimpleArrayTest {

    /**
     * Добавление элементов, в рамках размера структуры.
     */
    @Test
    public void whenAddElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("one");
        simpleArray.add("two");
        simpleArray.add("three");
        assertThat(simpleArray.get(0), is("one"));
        assertThat(simpleArray.get(1), is("two"));
        assertThat(simpleArray.get(2), is("three"));
    }

    /**
     * Тест структуры на отсутствие динамичности и выброс
     * исключения: выход за пределы массива.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOfBounds() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("1");
        simpleArray.add("2");
        simpleArray.add("3");
    }

    /**
     * Тест изменения элемента.
     */
    @Test
    public void whenSetElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("one");
        simpleArray.add("two");
        simpleArray.add("four");
        simpleArray.set(2, "three");
        assertThat(simpleArray.get(0), is("one"));
        assertThat(simpleArray.get(1), is("two"));
        assertThat(simpleArray.get(2), is("three"));
    }

    /**
     * Тест удаления элемента.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDelElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("one");
        simpleArray.add("two");
        simpleArray.add("three");
        simpleArray.remove(2);
        assertThat(simpleArray.get(0), is("one"));
        assertThat(simpleArray.get(1), is("two"));
        assertThat(simpleArray.get(2), nullValue());
        simpleArray.add("three");
        assertThat(simpleArray.get(2), is("three"));
    }

    /**
     * Комплексное тестирование итератора.
     */
    @Test
    public void complexIteratorTest() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        Iterator<String> iterator = simpleArray.iterator();
        simpleArray.add("one");
        simpleArray.add("two");
        simpleArray.add("three");
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("one"));
        assertThat(iterator.next(), is("two"));
        assertThat(iterator.next(), is("three"));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Тест итератора с выбрасыванием исключения.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorExeption() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        Iterator<String> iterator = simpleArray.iterator();
        simpleArray.add("one");
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("one"));
        assertThat(iterator.next(), is("two"));
    }
}
