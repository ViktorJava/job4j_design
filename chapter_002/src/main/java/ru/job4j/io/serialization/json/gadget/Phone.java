package ru.job4j.io.serialization.json.gadget;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * Класс {@link Phone} описывает телефон, с полями:
 * <ul>
 * <li>{@code available} - наличие в продаже
 * <li>{@code year} - год выпуска
 * <li>{@code spec} - член класса {@link Spec}
 * <li>{@code status} - old, new, broken, etc.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.04.2021
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

    public boolean isAvailable() {
        return available;
    }

    public int getYear() {
        return year;
    }

    public Spec getSpec() {
        return spec;
    }

    public String[] getStatus() {
        return status;
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

    /**
     * Реализация Json.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        final Phone phone = new Phone(true, 2010, new Spec(2, "MediaTek"), "broken", "old");
        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(phone));
        final String phoneJson =
                "{"
                        + "'available':true,"
                        + "'year':2021,"
                        + "'spec':"
                        + "{"
                        + "'ram':8,"
                        + "'cpu':'SnapDragon'"
                        + "},"
                        + "'status':"
                        + "['broken','new']"
                        + "}";
        final Phone phoneMod = gson.fromJson(phoneJson, Phone.class);
        System.out.println(phoneMod);
    }
}
