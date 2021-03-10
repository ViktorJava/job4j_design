package ru.job4j.io;

import java.io.FileOutputStream;

/**
 * Расчёт и побитовый вывод таблицы умножения  в файл.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.03.2021
 */
public class ResultFile {

    /**
     * Метод возвращает таблицу умножения и выводит в файл.
     *
     * @param size размер таблицы
     * @return таблица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        try (FileOutputStream out = new FileOutputStream("multiple.txt")) {
            for (int i = 0; i < size; i++) {
                out.write("\n".getBytes());
                for (int j = 0; j < size; j++) {
                    table[j][i] = (j + 1) * (i + 1);
                    String s = String.valueOf((j + 1) * (i + 1));
                    out.write(s.getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
}
