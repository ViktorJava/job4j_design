package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Две реализации чтения файла: побайтовое чтение
 * и через буферизированный поток.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.03.2021
 */
public class ReadFile {
    public static void main(String[] args) {
        bufferedReader("chapter_002/data/input.txt");
        streamReader("chapter_002/data/input.txt");
    }

    /**
     * Метод чтения файла через буферизированный поток и
     * вывод содержимого в консоль.
     *
     * @param file Имя файла данных.
     */
    public static void bufferedReader(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод побайтового чтения файла и вывод содержимого в консоль.
     *
     * @param file Имя файла данных.
     */
    public static void streamReader(String file) {
        try (FileInputStream in = new FileInputStream(file)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
