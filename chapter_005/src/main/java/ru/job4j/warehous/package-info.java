/**
 * 1. Создать класс Food с полями. Name, expiryDate, createDate, price, discount.
 * На основе класса Food создать другие продукты.
 * 2. Создать классы хранилище продуктов Warehouse, Shop, Trash.
 * 3. Создать класс обработчик перераспределения продуктов вместо использования.
 * ControlQuality. Класс должен перераспределять еду по хранилищам
 * в зависимости от условий.
 * <p>
 * 3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse;
 * 3.2. Если срок годности от 25% до 75% направить в Shop;
 * 3.3. Если срок годности больше 75% – то выставить скидку на продукт
 * и отправить в Shop;
 * 3.4. Если срок годности вышел. Отправить продукт в мусорку.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
package ru.job4j.warehous;
