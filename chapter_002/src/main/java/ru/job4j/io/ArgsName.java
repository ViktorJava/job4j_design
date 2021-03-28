package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Именованные аргументы</h2>
 * Класс реализует приём массива параметров и разбивание их на пары.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.03.2021
 */
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    /**
     * Метод возвращает значение ключа.
     *
     * @param key Ключ.
     * @return Значение
     */
    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("No such parameter exists");
        }
        return values.get(key);
    }

    /**
     * Приватный метод, парсит массив параметров полученный в виде аргумента.
     *
     * @param args Массив параметров в формате -ключ=значение.
     */
    private void parse(String[] args) {
        for (String arg: args) {
            String[] split = arg.replaceFirst("-", "").split("=");
            if (split.length != 2) {
                throw new IllegalArgumentException("argument must be: -param=value");
            }
            values.put(split[0], split[1]);
        }
    }

    /**
     * Фабричный метод.
     *
     * @param args Массив параметров в формате -ключ=значение.
     * @return Объект типа ArgsName с распарсенными параметрами.
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
