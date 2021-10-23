package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс кинотеатра.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10/23/2021
 */
public interface Cinema {
    /**
     * Поиск сеанса.
     *
     * @param filter Предикат поиска.
     * @return Список сеансов.
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Покупка билета.
     *
     * @param account Аккаунт покупателя.
     * @param row     Ряд места.
     * @param column  Столбец расположения места.
     * @param date    Дата сеанса.
     * @return Билет.
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Добавить сеанс.
     *
     * @param session Добавляемый сеанс.
     */
    void add(Session session);
}
