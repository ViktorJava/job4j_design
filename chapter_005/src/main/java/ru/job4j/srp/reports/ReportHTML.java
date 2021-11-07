package ru.job4j.srp.reports;

import java.util.function.Predicate;

/**
 * Отдел программистов.
 * <p>
 * Система отчетности отдела программистов в виде html.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 07.11.2021
 */
public class ReportHTML implements Report {
    private final Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML><html><head>")
            .append("<title>HTML отчёт.</title></head>")
            .append("<body><table>")
            .append("<tr><th>Name</th><th>Hired</th>")
            .append("<th>Fired</th><th>Salary</th></tr>");
        for (Employee employee: store.findBy(filter)) {
            text.append("<tr><td>")
                .append(employee.getName()).append("</td>").append("<td>")
                .append(employee.getFired()).append("</td>").append("<td>")
                .append(employee.getHired()).append("</td>").append("<td>")
                .append(employee.getSalary()).append("</td></tr>")
                .append("</table></body></htmal>")
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
