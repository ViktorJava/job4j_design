package ru.job4j.srp.reports;

import java.util.function.Predicate;

/**
 * Интерфейс системы отчётов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.11.2021
 */
public interface Report {
    String generate(Predicate<Employee> filter);
}
