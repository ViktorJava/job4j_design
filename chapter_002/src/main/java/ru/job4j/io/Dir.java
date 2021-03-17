package ru.job4j.io;

import java.io.File;

/**
 * <h2>File</h2>
 * Применение класса File. Взаимодействие с файловой системой.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.03.2021
 */
public class Dir {
    /**
     * Метод вывода файлов по заданному пути и их размера.
     *
     * @param args Аргументы метода.
     */
    public static void main(String[] args) {
        String dir = "c:\\projects\\job4j_design\\chapter_002\\src\\main\\java\\ru\\job4j\\io\\";
        File file = new File(dir);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("No exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("No directory %s",
                    file.getAbsoluteFile()));
        }
        for (File subFile: file.listFiles()) {
            System.out.printf("file name: %s, size: %d%n",
                    subFile.getName(), subFile.length());
        }
    }
}
