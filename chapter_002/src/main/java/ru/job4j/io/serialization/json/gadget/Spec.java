package ru.job4j.io.serialization.json.gadget;

/**
 * Класс {@link Spec} описывает спецификацию гаджета, с полями:
 * <ul>
 * <li>ram- объём оперативной памяти
 * <li>cpu- название процессора.
 * </ul>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.04.2021
 */
public class Spec {
    private final int ram;
    private final String cpu;

    public int getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public Spec(int ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Spec{" + "ram=" + ram + ", cpu='" + cpu + '\'' + '}';
    }
}
