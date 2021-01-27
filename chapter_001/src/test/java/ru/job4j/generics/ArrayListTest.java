package ru.job4j.generics;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.01.2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Test
    @Order(1)
    public void test() {
        arrayList.add(50);
        arrayList.add(22);
        arrayList.add(23);
        assertThat(arrayList.get(0), is(50));
        assertThat(arrayList.get(1), is(22));
        assertThat(arrayList.get(2), is(23));
    }
}