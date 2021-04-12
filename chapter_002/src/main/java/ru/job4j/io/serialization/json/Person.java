package ru.job4j.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * Класс описывающий человека.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.04.2021
 */
public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    /**
     * Реализация Json.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111-123"), "Worker", "Married");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "'sex':false,"
                        + "'age':41,"
                        + "'contact':"
                        + "{"
                        + "'phone':'+38(066)109-27-60'"
                        + "},"
                        + "'statuses':"
                        + "['Student','Free']"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
