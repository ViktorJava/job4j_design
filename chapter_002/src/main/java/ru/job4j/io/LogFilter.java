package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Фильтрация лог файла.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.03.2021
 */
public class LogFilter {
    /**
     * Метод применяет буферизированный поток, фильтрует лог файл.
     *
     * @param file Имя лог файла.
     * @return Список отфильтрованных строк.
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines()
              .filter(e -> e.contains("404"))
              .forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод получает данные лог файла на вход и записывает в файл.
     *
     * @param log  Записываемые данные.
     * @param file Имя файла.
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String s: log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("chapter_002/data/log.txt");
        save(log, "chapter_002/data/404.txt");
    }
}
