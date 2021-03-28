package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <h2>Архивировать проект</h2>
 * Класс, представляет собой, утилиту для архивации папки.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.03.2021
 */
public class Zip {
    /**
     * Метод архивирует файлы, путь и имя которых получаем через аргумент
     * в виде списка.
     *
     * @param sources Список архивируемых файлов.
     * @param target  Имя и расширение архивного файла.
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        Path root = Paths.get(argsName.get("d")); //directory
        try {
            List<Path> listPath = Search.search(root,
                    p -> !p.toFile()
                           .getName()
                           .endsWith(argsName.get("e"))); //exclude
            List<File> listFile = new ArrayList<>();
            for (Path path: listPath) {
                listFile.add(path.toFile());
            }
            new Zip().packFiles(listFile, new File(argsName.get("o"))); //output
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
