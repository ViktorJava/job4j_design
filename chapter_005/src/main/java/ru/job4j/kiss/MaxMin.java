package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

/**
 * Принципы Kiss, Dry и Yagni [#238813]
 * <p>Класс для поиска максимального и минимального элемента
 * по критерию java.util.Comparator.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/4/2021
 */
public class MaxMin {

    /**
     * Поиск максимального элемента в списке.
     *
     * @param value      Список элементов типа Т.
     * @param comparator Comparator типа Т.
     * @param <T>        Тип элементов в списке.
     * @return Максимальное значение.
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calculation(value, comparator);
    }

    /**
     * Поиск минимального элемента в списке.
     *
     * @param value      Список элементов типа Т.
     * @param comparator Comparator типа Т.
     * @param <T>        Тип элементов в списке.
     * @return Минимальное значение.
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return calculation(value, comparator.reversed());
    }

    /**
     * Метод сравнения элементов.
     *
     * @param value      Список элементов типа Т.
     * @param comparator Компаратор типа Т.
     * @param <T>        Тип элементов.
     * @return Результат сравнения элементов по критерию Comparator.
     */
    private <T> T calculation(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T e: value) {
            rsl = comparator.compare(rsl, e) > 0 ? rsl : e;
        }
        return rsl;
    }
}
