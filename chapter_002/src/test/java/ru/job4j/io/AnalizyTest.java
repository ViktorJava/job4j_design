package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты анализа доступности сервера.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.03.2021
 */
public class AnalizyTest {
    @Test
    public void whatNotWorkServer() {
        Analizy analizy = new Analizy();
        StringBuilder rsl = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        analizy.unavailable("./data/logServer.csv", "./data/result.csv");
        try {
            BufferedReader in = new BufferedReader(new FileReader("./data/result.csv"));
            in.lines().forEach(rsl::append);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        expected.append("10:57:01-10:59:01;").append("11:01:02-11:02:02;");
        assertThat(expected.toString(), is(rsl.toString()));
    }
}
