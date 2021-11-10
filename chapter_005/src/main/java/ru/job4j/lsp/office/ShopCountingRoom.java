package ru.job4j.lsp.office;

/**
 * Бухгалтерия магазина.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class ShopCountingRoom extends CountingRoom {
    /**
     * Конструктор.
     *
     * @param normHours  Норма часов.
     * @param payPerHour Оплата за отработанный час.
     */
    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }

    /**
     * Метод расчёта заработной платы магазина.
     *
     * @param workDays Количество отработанных дней.
     * @return Заработная плата.
     */
    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay: workDays) {
            factHours += hoursPerDay;
        }
        return factHours * payPerHour;
    }
}
