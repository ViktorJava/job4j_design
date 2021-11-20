package ru.job4j.lsp.warehouse;

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
        double startRange = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double fullRange = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        if (startRange < 0 || fullRange <= 0) {
            throw new IllegalArgumentException("Create date over or equals expiry date.");
        }
        return (int) (startRange / fullRange * 100);
    }
}
