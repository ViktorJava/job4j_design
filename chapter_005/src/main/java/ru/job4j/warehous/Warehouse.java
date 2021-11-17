package ru.job4j.warehous;

import java.util.ArrayList;
import java.util.List;

/**
 * Склад.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class Warehouse implements Storage {
    private final List<Food> foodList = new ArrayList<>();

    /**
     * Метод добавляет продукты на склад на основании ограничений.
     *
     * @param food Объект типа Food.
     */

    @Override
    public void put(Food food) {
        if (condition(food)) {
            foodList.add(food);
            System.out.println("add warehouse");
        }

    }

    /**
     * Метод возвращает все продукты на складе, в виде списка.
     *
     * @return Список продуктов.
     */
    @Override
    public List<Food> get() {
        return foodList;
    }

    /**
     * Метод проверяет ограничения продукта.
     *
     * @param food Объект типа Food.
     * @return true в случае добавления продукта на склад, иначе false.
     */
    public boolean condition(Food food) {
        return Percent.percent(food) < 25;
    }
}
