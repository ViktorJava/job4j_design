package ru.job4j.lsp.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Магазин реализует абстрактное хранилище.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class Shop implements Storage {
    private final List<Food> foodList = new ArrayList<>();
    public static final int DISCOUNT = 25;

    /**
     * Метод добавляет продукты в магазин.
     *
     * @param food Объект типа Food.
     * @return true в случае приёмки продукта в хранилище, иначе false.
     */
    @Override
    public boolean put(Food food) {
        if (accept(food)) {
            foodList.add(food);
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает все продукты магазина в виде списка.
     *
     * @return Список продуктов.
     */
    @Override
    public List<Food> get() {
        return new ArrayList<>(foodList);
    }


    /**
     * Метод проверяет ограничения продукта.
     *
     * @param food Объект типа Food.
     * @return true в случае добавления продукта в магазин иначе false.
     */

    public boolean accept(Food food) {
        int curPercent = Percent.getPercentage(food);
        if (curPercent >= 25 && curPercent <= 75) {
            return true;
        }
        if (curPercent > 75 && curPercent <= 100) {
            food.setDiscount(DISCOUNT);
            return true;
        }
        return false;
    }
}
