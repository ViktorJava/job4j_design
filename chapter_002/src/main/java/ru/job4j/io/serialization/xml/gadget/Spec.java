package ru.job4j.io.serialization.xml.gadget;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Класс {@link Spec} описывает спецификацию гаджета, с полями:
 * <ul>
 * <li>ram- объём оперативной памяти
 * <li>cpu- название процессора.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
@XmlElement(value = "spec")
public class Spec {
    @XmlAttribute
    private int ram;
    @XmlAttribute
    private String cpu;

    public Spec(int ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    public Spec() {
    }

    @Override
    public String toString() {
        return "Spec{"
                + "ram=" + ram
                + ", cpu='" + cpu + '\''
                + '}';
    }
}
