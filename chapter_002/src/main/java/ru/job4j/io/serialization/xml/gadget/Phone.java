package ru.job4j.io.serialization.xml.gadget;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

/**
 * Класс {@link Phone} описывает телефон, с полями:
 * <ul>
 * <li>{@code available} - наличие в продаже
 * <li>{@code year} - год выпуска
 * <li>{@code spec} - член класса {@link Spec}
 * <li>{@code status} - old, new, broken, etc.
 * </ul>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
    @XmlAttribute
    private boolean available;
    @XmlAttribute
    private int year;
    private Spec spec;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] status;

    public Phone(boolean available, int year, Spec spec, String... status) {
        this.available = available;
        this.year = year;
        this.spec = spec;
        this.status = status;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone{"
                + "available=" + available
                + ", year=" + year
                + ", spec=" + spec
                + ", status=" + Arrays.toString(status)
                + '}';
    }
}
