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
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("No exist %s",
                    file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("No directory %s",
                    file.getAbsoluteFile()));
        }
        int totalSize = 0;
        for (File subFile: file.listFiles()) {
            totalSize += (int) subFile.length();
            System.out.printf("file name: %s, size: %d%n",
                    subFile.getName(), subFile.length());
        }
        System.out.printf("Total size: %d Kb", totalSize);
    }
}
