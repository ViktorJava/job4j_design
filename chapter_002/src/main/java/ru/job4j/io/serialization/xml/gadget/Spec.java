package ru.job4j.io.serialization.xml.gadget;

/**
 * Класс Spec описывает спецификацию гаджета, с полями:
 * ram- объём оперативной памяти, cpu- название процессора.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
public class Spec {
    private final int ram;
    private final String cpu;

    public Spec(int ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Spec{"
                + "ram=" + ram
                + ", cpu='" + cpu + '\''
                + '}';
    }
}
