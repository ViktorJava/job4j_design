package ru.job4j.lsp.violation.stor;

/**
 * Класс супермаркета.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.11.2021
 */
public class SuperStor extends Stor {
    /**
     * Конструктор.
     *
     * @param amount Единиц покупаемого товара.
     */
    public SuperStor(int amount) {
        super(amount);
    }

    /**
     * Покупка товара.
     *
     * @param money Оплата за товар.
     */
    @Override
    public void buy(int money) {
        if (amount > 3) {
            throw new IllegalArgumentException("Не более 3 единиц в один чек.");
        }
        System.out.printf("Товара: %d единиц. Оплачено: %d cr.", amount, money);
    }
}
