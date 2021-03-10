package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
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
        List<String> temp = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(temp::add);
            for (String s: temp) {
                if (s.contains("404")) {
                    result.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.print(log);
    }
}
