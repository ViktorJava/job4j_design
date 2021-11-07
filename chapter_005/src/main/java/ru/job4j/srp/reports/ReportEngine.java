package ru.job4j.srp.reports;

import java.util.function.Predicate;

/**
 * Реализация механизма отчётов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.11.2021
 */
public class ReportEngine implements Report {
    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator());
        for (Employee employee: store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
