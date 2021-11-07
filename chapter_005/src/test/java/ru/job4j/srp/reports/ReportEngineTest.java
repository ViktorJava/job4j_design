package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты систем отчётов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.11.2021
 */
public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * Отчет бухгалтерии.
     */
    @Test
    public void whenReportAcc() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report reportAcc = new ReportAcc(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary USD;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 0.71).append(";")
                .append(System.lineSeparator());
        assertThat(reportAcc.generate(em -> true), is(expect.toString()));
    }

    /**
     * Отдел HR.
     */
    @Test
    public void whenReportHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        Employee workerSecond = new Employee("Viktor", now, now, 200);
        store.add(workerFirst);
        store.add(workerSecond);
        Report reportHR = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerSecond.getName()).append(";")
                .append(workerSecond.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerFirst.getName()).append(";")
                .append(workerFirst.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(reportHR.generate(em -> true), is(expect.toString()));
    }

    /**
     * Отдел программистов.
     */
    @Test
    public void whenReportHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report reportHTML = new ReportHTML(store);
        StringBuilder expected = new StringBuilder()
                .append("<!DOCTYPE HTML><html><head>")
                .append("<title>HTML отчёт.</title></head>")
                .append("<body><table>")
                .append("<tr><th>Name</th><th>Hired</th>")
                .append("<th>Fired</th><th>Salary</th></tr>")
                .append("<tr><td>").append(worker.getName()).append("</td>")
                .append("<td>").append(worker.getFired()).append("</td>")
                .append("<td>").append(worker.getHired()).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td></tr>")
                .append("</table></body></htmal>")
                .append(System.lineSeparator());
        assertThat(reportHTML.generate(em -> true), is(expected.toString()));
    }
}
