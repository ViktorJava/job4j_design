package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Тесты простого динамического хранилища.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 30.01.2021
 */
public class SimpleArrayDTest {
    SimpleArrayD<String> arrayString = new SimpleArrayD<>();

    @Test
    public void whenAddThenGet() {
        arrayString.add("first");
        String rsl = arrayString.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        arrayString.add("first");
        String rsl = arrayString.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        arrayString.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        arrayString.add("first");
        arrayString.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        arrayString.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedAdd() {
        arrayString.add("first");
        Iterator<String> it = arrayString.iterator();
        arrayString.add("second");
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedAddByIndex() {
        arrayString.add("first");
        Iterator<String> it = arrayString.iterator();
        arrayString.add(0, "second");
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedRemove() {
        arrayString.add("first");
        arrayString.add("second");
        Iterator<String> it = arrayString.iterator();
        arrayString.remove(0);
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedSet() {
        arrayString.add("first");
        arrayString.add("second");
        Iterator<String> it = arrayString.iterator();
        arrayString.set(0, "zero");
        it.next();
    }

    @Test
    public void whenGetLast() {
        arrayString.add("ten");
        arrayString.add("twenty");
        arrayString.add("thirty");
        assertThat(arrayString.getLast(), is("thirty"));
    }

    @Test
    public void whenGetFirst() {
        arrayString.add("ten");
        arrayString.add("twenty");
        arrayString.add("thirty");
        assertThat(arrayString.getFirst(), is("ten"));
    }

    @Test
    public void listSpecificCapacity() {
        SimpleArrayD<Integer> simpleArrayD = new SimpleArrayD<>(3);
        simpleArrayD.add(10);
        simpleArrayD.add(15);
        simpleArrayD.add(20);
        assertThat(simpleArrayD.get(0), is(10));
        assertThat(simpleArrayD.get(1), is(15));
        assertThat(simpleArrayD.get(2), is(20));
    }

    @Test
    public void whenDynamicCapacity() {
        SimpleArrayD<Integer> simpleArrayD = new SimpleArrayD<>(2);
        simpleArrayD.add(10);
        simpleArrayD.add(15);
        simpleArrayD.add(20);
        assertThat(simpleArrayD.get(0), is(10));
        assertThat(simpleArrayD.get(1), is(15));
        assertThat(simpleArrayD.get(2), is(20));
    }

    @Test
    public void whenClearSizeConteins() {
        arrayString.add("ten");
        arrayString.add("twenty");
        arrayString.add("thirty");
        assertThat(arrayString.contains("twenty"), is(true));
        arrayString.clear();
        assertThat(arrayString.size(), is(0));
    }

    @Test
    public void whenRemoveElement() {
        arrayString.add("first");
        arrayString.add("second");
        assertThat(arrayString.remove(0), is("first"));
    }
}
