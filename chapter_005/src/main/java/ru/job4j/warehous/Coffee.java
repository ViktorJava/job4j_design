package ru.job4j.warehous;

import java.time.LocalDate;

/**
 * Кофе.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class Coffee extends Food {
    /**
     * Конструктор объекта типа Food.
     *
     * @param name       Название продукта.
     * @param createDate Дата производства.
     * @param expiryDate Срок годности.
     * @param price      Цена.
     * @param discount   Скидка.
     */
    public Coffee(String name, LocalDate createDate, LocalDate expiryDate,
                  double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
