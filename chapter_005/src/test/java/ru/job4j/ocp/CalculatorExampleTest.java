package ru.job4j.ocp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static ru.job4j.ocp.CalculatorExample.*;

/**
 * Тесты калькуляторов, выполненных с нарушением и без нарушения принципа OCP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 09.11.2021
 */
public class CalculatorExampleTest {

    @Test
    public void whenMultiplicationAbstractCalculator() {
        AbstractCalculator<Integer> ac = new AbstractCalculator<>();
        assertThat(ac.calculate((a, b) -> a * b, 10, 20), is(200));
    }

    @Test
    public void whenSumAbstractCalculator() {
        AbstractCalculator<Integer> ac = new AbstractCalculator<>();
        assertThat(ac.calculate(Integer::sum, 10, 20), is(30));
    }

    @Test
    public void whenSumSimpleCalculator() {
        SimpleCalculator sc = new SimpleCalculator();
        assertThat(sc.sum(2, 2), is(4));
    }

    @Test
    public void whenMultiSumExtendsCalculator() {
        ExtendsCalculator ec = new ExtendsCalculator();
        assertThat(ec.multi(10, 10), is(100));
        assertThat(ec.sum(10, 10), is(20));
    }
}