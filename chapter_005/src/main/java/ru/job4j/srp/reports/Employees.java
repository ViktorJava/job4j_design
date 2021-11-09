package ru.job4j.srp.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Вспомогательный класс для JAXB сериализации объектов в XML.
 * Используется рефлексия для чтения полей объектов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 09.11.2021
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    private Employees() {
    }

    @XmlElement(name = "employee")
    private List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }
}
