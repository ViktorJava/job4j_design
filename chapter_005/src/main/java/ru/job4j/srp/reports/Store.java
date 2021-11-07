package ru.job4j.srp.reports;

import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс хранилища данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.11.2021
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
