package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <h2>Чтение файла конфигурации.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.03.2021
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод должен считать все ключи и их значения в карту values.
     * В файле могут быть пустые строки и комментарии, их пропускаем.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                .filter(e -> !e.contains("#") && e.contains("="))
                .map(e -> e.split("="))
                .filter(e -> e.length > 1)
                .forEach(e -> values.put(e[0], e[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод читает файл конфигурации.
     * Структура файла: ключ = значение, могут быть пустые строки и комментарии.
     * Этот метод резервный, не введён в эксплуатацию.
     */
    public void loadReserv() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            Predicate<String> isCommented = s -> s.startsWith("#");
            Predicate<String> isEmpty = String::isEmpty;
            values.putAll(read
                    .lines()
                    .filter(isCommented.negate().and(isEmpty.negate()))
                    .map(s -> s.split("="))
                    .filter(e -> e.length > 1)
                    .collect(Collectors.toMap(s -> s[0], s -> s[1]))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает значение ключа.
     *
     * @param key Ключ.
     * @return Значение ключа.
     */
    public String value(String key) {
        if (!values.containsKey(key)) {
            throw new UnsupportedOperationException("Value is empty!");
        }
        return values.get(key);
    }
}
