package ru.job4j.srp.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.function.Predicate;

/**
 * Генерация отчёта в JSON формате.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 09.11.2021
 */
public class ReportJSON implements Report {
    private final Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(store.findBy(filter));
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 800);
        store.add(worker);
        Report reportJSON = new ReportJSON(store);
        System.out.println(reportJSON.generate(em -> true));
    }
}
