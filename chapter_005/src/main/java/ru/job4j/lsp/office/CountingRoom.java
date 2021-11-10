package ru.job4j.lsp.office;

/**
 * Класс бухгалтерии.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class CountingRoom {
    protected int normHours;
    protected int payPerHour;

    /**
     * Конструктор.
     *
     * @param normHours  Норма часов.
     * @param payPerHour Оплата за отработанный час.
     */
    public CountingRoom(int normHours, int payPerHour) {
        this.normHours = normHours;
        this.payPerHour = payPerHour;
    }

    /**
     * Метод расчёта зарплаты.
     *
     * @param workDays Количество отработанных дней.
     * @return Заработная плата.
     */
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay: workDays) {
            factHours += hoursPerDay;
        }
        if (factHours < normHours) {
            throw new IllegalArgumentException("Worker didn't work enough!");
        }
        return factHours * payPerHour;
    }
}
