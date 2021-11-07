package ru.job4j.srp.reports;

import java.util.function.Predicate;

/**
 * Бухгалтерский отчёт.
 * <p>
 * Отдел бухгалтерии попросил изменить вид зарплаты (сделал в долларах).
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 07.11.2021
 */
public class ReportAcc implements Report {
    private final Store store;

    public ReportAcc(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary USD;")
            .append(System.lineSeparator());
        for (Employee employee: store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getSalary() / 0.71).append(";")
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
