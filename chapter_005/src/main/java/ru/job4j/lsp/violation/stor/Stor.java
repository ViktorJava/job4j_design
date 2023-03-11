package ru.job4j.lsp.violation.stor;

/**
 * Класс магазина.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.11.2021
 */
public class Stor {
    /**
     * Единиц покупаемого товара.
     */
    protected int amount;

    public Stor(int amount) {
        this.amount = amount;
    }

    /**
     * Покупка товара.
     *
     * @param money Оплата за товар.
     */
    public void buy(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Дефицит средств.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Дефицит предложения.");
        }
        System.out.printf("Товара: %d единиц. Оплачено: %d cr.", amount, money);
    }
}
