package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

/**
 * <h2>5.2.1. Реализовать SimpleArray [#438902]</h2>
 * Необходимо сделать универсальную обертку над массивом.
 *
 * <p> Добавить методы:
 * <ul>
 * <li>{@code add(T model)} - добавляет указанный элемент (model)
 * в первую свободную ячейку;
 * <li>{@code set(int index, T model)} - заменяет указанным элементом (model)
 * элемент, находящийся по индексу index;
 * <li>{@code remove(int index)} - удаляет элемент по указанному индексу,
 * все находящиеся справа элементы при этом необходимо сдвинуть на единицу
 * влево (в середине массива не должно быть пустых ячеек);
 * <li>{@code get(int index)} - возвращает элемент, расположенный
 * по указанному индексу;
 * </ul>
 * <p>Также, реализовать интерфейс Iterable.<T>
 * Метод {@code iterator()} возвращает итератор, предназначенный
 * для обхода данной структуры.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @implNote Объект должен принимать количество ячеек. Структура не должна
 * быть динамической.
 * 1. В методах, где используется индекс нужно делать валидацию.
 * Индекс должен находиться в рамках добавленных элементов.
 * Например, есть хранилище из 10 элементов. Добавляем 3 элемента.
 * Каким может быть индекс? [0, 2]. Для проверки индекса используем метод
 * {@code Objects.checkIndex()}.
 * 2. Для удаления использовать {@code System.arraycopy()} вместо цикла.
 * @since 22.01.2021
 */
public class SimpleArray<T> implements Iterable<T> {
    private final Object[] elements;
    private int pos = 0;

    public SimpleArray(int size) {
        this.elements = new Object[size];
    }

    /**
     * Метод добавляет указанный элемент (model) в первую свободную ячейку;
     *
     * @param model Добавляемый элемент.
     * @throws IndexOutOfBoundsException Переполнение структуры.
     */
    public void add(T model) throws IndexOutOfBoundsException {
        elements[pos++] = model;
    }

    /**
     * Метод заменяет указанным элементом (model) элемент,
     * находящийся по индексу index;
     *
     * @param index Индекс заменяемого элемента.
     * @param model Новый элемент.
     * @throws IndexOutOfBoundsException Выход индекса за пределы структуры.
     */
    public void set(int index, T model) throws IndexOutOfBoundsException {
        checkIndex(index, pos);
        elements[index] = model;
    }

    /**
     * Метод возвращает элемент, расположенный по указанному индексу;
     *
     * @param index Индекс возвращаемого элемента.
     * @return Возвращаемый элемент.
     * @throws IndexOutOfBoundsException Выход индекса за пределы структуры.
     */

    public T get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, pos);
        return (T) elements[index];
    }

    /**
     * Метод удаляет элемент по указанному индексу;
     *
     * @param index Индекс удаляемого элемента.
     * @throws IndexOutOfBoundsException Выход индекса за пределы структуры.
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, pos);
        System.arraycopy(elements, index + 1, elements, index,
                elements.length - index - 1);
        elements[--this.pos] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < pos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[counter++];
            }
        };
    }
}
