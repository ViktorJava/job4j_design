package ru.job4j.srp.reports;

import org.junit.Test;

import java.text.SimpleDateFormat;
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

    /**
     * Тест генератора отчёта в JSON формате.
     */
    @Test
    public void whenReportJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 800);
        store.add(worker);
        Report reportJSON = new ReportJSON(store);
        StringBuilder expected = new StringBuilder()
                .append("[{\"name\":\"Ivan\",\"hired\":{\"year\":")
                .append(worker.getHired().get(Calendar.YEAR))
                .append(",").append("\"month\":")
                .append(worker.getHired().get(Calendar.MONTH))
                .append(",").append("\"dayOfMonth\":")
                .append(worker.getHired().get(Calendar.DAY_OF_MONTH))
                .append(",").append("\"hourOfDay\":")
                .append(worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",").append("\"minute\":")
                .append(worker.getHired().get(Calendar.MINUTE))
                .append(",").append("\"second\":")
                .append(worker.getHired().get(Calendar.SECOND))
                .append("},").append("\"fired\":{\"year\":")
                .append(worker.getHired().get(Calendar.YEAR))
                .append(",").append("\"month\":")
                .append(worker.getHired().get(Calendar.MONTH))
                .append(",").append("\"dayOfMonth\":")
                .append(worker.getHired().get(Calendar.DAY_OF_MONTH))
                .append(",").append("\"hourOfDay\":")
                .append(worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",").append("\"minute\":")
                .append(worker.getHired().get(Calendar.MINUTE))
                .append(",").append("\"second\":")
                .append(worker.getHired().get(Calendar.SECOND))
                .append("},").append("\"salary\":800.0}]");
        assertThat(reportJSON.generate(em -> true), is(expected.toString()));
    }

    /**
     * Тест генератора отчёта в XML формате.
     */
    @Test
    public void whenReportXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100500);
        store.add(worker);
        Report report = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(format.format(worker.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(format.format(worker.getHired().getTime())).append("</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100500.0</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(report.generate(em -> true), is(expect.toString()));
    }
}
