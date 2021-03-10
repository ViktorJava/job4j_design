package ru.job4j.io;

import java.io.FileInputStream;

/**
 * <h2>FileInputStream</h2>
 * Класс читает файл even.txt. Для каждого числа проверить
 * является ли оно четным числом. Ответ вывести на консоль.<p>
 * В файле even.txt числа. Одно число  на строку.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.03.2021
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line: lines) {
            int n = Integer.parseInt(line);
            if (n % 2 == 0) {
                System.out.println(n + " - чётное");
            } else {
                System.out.println(n + " - нечётное");
            }
        }
    }
}
