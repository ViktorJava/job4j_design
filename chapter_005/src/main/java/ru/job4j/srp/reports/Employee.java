package ru.job4j.srp.reports;

import java.util.Calendar;
import java.util.Objects;

/**
 * Модель данных сотрудников.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.11.2021
 */
public class Employee {
    /**
     * Имя сотрудника.
     */
    private String name;
    /**
     * Дата найма на работу.
     */
    private Calendar hired;
    /**
     * Дата увольнения.
     */
    private Calendar fired;
    /**
     * Заработная плата.
     */
    private double salary;

    public Employee(String name, Calendar hired, Calendar fired,
                    double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
