package ru.job4j.generics;

import java.util.Iterator;

/**
 * <h2>5.2.1. Реализовать SimpleArray [#438902]</h2>
 * В этом задании необходимо сделать универсальную обертку над массивом.
 *
 * <p> Добавить методы:
 * <ul>
 * <li>{@code add(T model)} - добавляет указанный элемент (model) в первую свободную ячейку;
 * <li>{@code set(int index, T model)} - заменяет указанным элементом (model) элемент, находящийся по индексу index;
 * <li>{@code remove(int index)} - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
 * необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
 * <li>{@code get(int index)} - возвращает элемент, расположенный по указанному индексу;
 * </ul>
 * <p>Также, реализуйте интерфейс Iterable<T> - метод {@code iterator()} возвращает итератор,
 * предназначенный для обхода данной структуры.
 *
 * <p>Объект должен принимать количество ячеек. Структура не должна быть динамической.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @implNote 1. В методах, где используется индекс нужно делать валидацию.
 * Индекс должен находиться в рамках добавленных элементов.
 * Например, у вас есть хранилище из 10 элементов. Вы добавили 3 элемента.
 * Каким может быть индекс? [0, 2]. Для проверки индекса используйте метод Objects.checkIndex.
 *
 * <p>2. Для удаления использовать {@code System.arraycopy()} вместо цикла.
 * @since 22.01.2021
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] elements;
    private int pos = 0;

    public SimpleArray(Object[] size) {
        this.elements = size;
    }

    /**
     * Метод добавляет указанный элемент (model) в первую свободную ячейку;
     *
     * @param model Добавляемый элемент.
     */
    public void add(T model) {

    }

    /**
     * Метод заменяет указанным элементом (model) элемент, находящийся по индексу index;
     *
     * @param index Индекс заменяемого элемента.
     * @param model Новый элемент.
     */
    public void set(int index, T model) {

    }

    /**
     * Метод удаляет элемент по указанному индексу;
     *
     * @param index Индекс удаляемого элемента.
     */
    public void remove(int index) {

    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу;
     *
     * @param index Индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     */
    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
