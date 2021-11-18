package ru.job4j.warehous;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Свалка.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class Trash implements Storage {
    private final List<Food> foodList = new ArrayList<>();

    /**
     * Метод отправляет  продукты на свалку.
     *
     * @param food Объект типа Food.
     */
    @Override
    public void put(Food food) {
        if (condition(food)) {
            foodList.add(food);
        }
    }

    /**
     * Метод возвращает все продукты отправленные на свалку, в виде списка.
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
     * @return true в случае отправки продукта на свалку, иначе false.
     */
    @Override
    public boolean condition(Food food) {
        return LocalDate.now().isAfter(food.getExpiryDate());
    }
}
