package ru.job4j.warehous;

import java.time.LocalDate;

/**
 * Супер-класс продуктов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expiryDate;
    private double price;
    int discount;

    /**
     * Конструктор объекта типа Food.
     *
     * @param name       Название продукта.
     * @param createDate Дата производства.
     * @param expiryDate Срок годности.
     * @param price      Цена.
     * @param discount   Скидка.
     */
    public Food(String name, LocalDate createDate, LocalDate expiryDate,
                double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Для красоты и отладки.
     *
     * @return Состояние объекта в виде строки.
     */
    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
