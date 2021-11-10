package ru.job4j.lsp.office;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Класс рабочих дней.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class WorkDays implements Iterable<Integer> {
    /**
     * Хранилище отработанных дней.
     */
    private final Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    /**
     * Метод добавления отработанных дней в хранилище.
     *
     * @param date  Дата рабочего дня.
     * @param hours Отработано часов в этот день.
     */
    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    /**
     * Итератор по хранилищу отработанных дней.
     *
     * @return Итератор типа Integer перемещающийся по value в хранилище.
     */
    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}
