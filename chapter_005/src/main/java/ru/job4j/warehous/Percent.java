package ru.job4j.warehous;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Процент несвежести продукта.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 16.11.2021
 */
public class Percent {
    /**
     * Метод расчёта процента несвежести продукта.
     * <p>
     * a дней = количество дней с даты создания продукта по сегодня;
     * b дней = количество дней за весь срок годности;
     * % = процент несвежести продукта;
     * ----------
     * % = a / b * 100;
     *
     * @param food Объект типа Food.
     * @return Процент несвежести продукта.
     */
    public static int getPercentage(Food food) {
        double a = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double b = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        if (a < 0 || b <= 0) {
            throw new IllegalArgumentException("Create date over or equals expiry date.");
        }
        return (int) (a / b * 100);
    }
}
