package ru.job4j.io.serialization.xml.gadget;

import java.util.Arrays;

/**
 * Класс Phone описывает телефон, с полями:
 * available- наличие в продаже, year- год выпуска, spec- член класса Spec,
 * status- old, new, broken, etc.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
public class Phone {
    private final boolean available;
    private final int year;
    private final Spec spec;
    private final String[] status;

    public Phone(boolean available, int year, Spec spec, String... status) {
        this.available = available;
        this.year = year;
        this.spec = spec;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "available=" + available +
                ", year=" + year +
                ", spec=" + spec +
                ", status=" + Arrays.toString(status) +
                '}';
    }

    public static void main(String[] args) {
        Phone phone = new Phone(true, 2021, new
                Spec(8, "SnapDragon"), "new", "broken");
    }
}
