package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Шаблонизатор. [#855]<p>
 * Тесты описывающие поведение генератора.<p>
 * Генератор получает шаблон вида "I am a ${name}, Who are ${subject}?"<p>
 * Генератор должен вернуть строку: "I am a Petr Arsentev, Who are you?"<p>
 * Программа должна учитывать, что в шаблоне есть ключи, которых нет в карте и кидать исключение.<p>
 * Программа должна учитывать, что в карте есть лишние ключи и тоже кидать исключение.<p>
 * Задача.<p>
 * Написать тесты описывающие поведение генератора.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10/23/2021
 */
public class ImpGeneratorTest {
    /**
     * Всё хорошо.
     */
    @Test
    public void whenOK() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Viktor");
        map.put("subject", "you");
        Generator generator = new ImpGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Viktor, Who are you?";
        String rsl = generator.producer(template, map);
        assertThat(rsl, is(expected));
    }

    /**
     * в карте есть лишние ключи
     */
    @Test(expected = NoSuchElementException.class)
    public void whenManyKey() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Viktor");
        map.put("subject", "you");
        map.put("title", "sir");
        Generator generator = new ImpGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        generator.producer(template, map);
    }

    /**
     * В шаблоне есть ключи, которых нет в карте.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAnotherKeys() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Viktor");
        map.put("nickName", "Terminator");
        Generator generator = new ImpGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        generator.producer(template, map);
    }
}
