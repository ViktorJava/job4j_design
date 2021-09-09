package ru.job4j.gc;

import java.util.Random;

/**
 * Класс предназначен для непрерывного заполнения памяти, с целю мониторинга
 * срабатывания GC.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/9/2021
 */
public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}
