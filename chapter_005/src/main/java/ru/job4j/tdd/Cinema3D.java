package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * Заглушка-реализация интерфейса кинотеатра.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10/23/2021
 */
public class Cinema3D implements Cinema {
    /**
     * Поиск сеанса.
     *
     * @param filter Предикат поиска.
     * @return Список сеансов.
     */
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    /**
     * Покупка билета.
     *
     * @param account Аккаунт покупателя.
     * @param row     Ряд места.
     * @param column  Столбец расположения места.
     * @param date    Дата сеанса.
     * @return Билет.
     */
    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    /**
     * Добавить сеанс.
     *
     * @param session Добавляемый сеанс.
     */
    @Override
    public void add(Session session) {
    }
}
