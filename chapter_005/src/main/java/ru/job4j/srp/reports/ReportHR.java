package ru.job4j.srp.reports;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * HR отдел.
 * <p>
 * Отдел HR попросил выводить сотрудников в порядке убывания зарплаты
 * и убрать поля даты найма и увольнения.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 07.11.2021
 */
public class ReportHR implements Report {
    private final Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        text.append("Name; Salary;")
            .append(System.lineSeparator());
        for (Employee employee: employees) {
            text.append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
