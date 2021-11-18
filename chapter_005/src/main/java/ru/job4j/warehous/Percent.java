package ru.job4j.warehous;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Срок годности продукта.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 16.11.2021
 */
public class Percent {
    /**
     * Метод расчёта процента, срока годности.
     * <p>
     * a дней = количество дней с даты создания продукта по сегодня.
     * b дней = количество дней за весь срок годности.
     * % = процент годности продукта.
     * ----------
     * % = a / b * 100
     *
     * @param food Объект типа Food.
     * @return Процент срока годности продукта.
     */
    public static int percent(Food food) {
        double a = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double b = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return (int) (a / b * 100);
    }
}
