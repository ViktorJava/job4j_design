package ru.job4j.generics;

/**
 * Модель данных описывающая животного.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.01.2021
 */
public class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", age=" + age + '}';
    }
}
