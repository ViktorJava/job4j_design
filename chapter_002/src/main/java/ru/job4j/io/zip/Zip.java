package ru.job4j.io.zip;

import ru.job4j.io.ArgsName;
import ru.job4j.io.searcher.Search;

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

    /**
     * Метод формирует список всех файлов в заданном каталоге
     * включая подкаталоги учитывая исключенные файлы.
     *
     * @param filePath Корневой каталог.
     * @param exclude   Расширение исключенных файлов.
     * @return Список файлов.
     */
    private static List<File> searchFile(Path filePath, String exclude) {
        List<Path> listPaths = new ArrayList<>();
        try {
            listPaths = Search.search(filePath,
                    p -> !p.toFile()
                           .getName()
                           .endsWith(exclude));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<File> listFiles = new ArrayList<>();
        for (Path path: listPaths) {
            listFiles.add(path.toFile());
        }
        return listFiles;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Example: java -jar pack.jar <PATH> <EXCLUDE_FILE> <ARCHIVE_NAME>");
        }
        ArgsName argsName = ArgsName.of(args);
        Path root = Paths.get(argsName.get("d")); //directory
        new Zip().packFiles(searchFile(root, argsName.get("e")), //exclude
                new File(argsName.get("o"))); //output
    }
}
