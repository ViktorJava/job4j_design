package ru.job4j.io.searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * <h2>Сканирование файловой системы.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.03.2021
 */
public class Search {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Example: java -jar search.jar <Path> <FileExtension>");
        }
        Path start = Paths.get(args[0]);
        search(start, p -> p
                .toFile()
                .getName()
                .endsWith(args[1])).forEach(System.out::println);
    }

    /**
     * Метод поиска файлов в заданной директории, согласно предикату.
     *
     * @param root      Корневая директория.
     * @param condition Предикат поиска файлов.
     * @return Список найденных файлов.
     * @throws IOException При возникновении IO исключений.
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        PrintFiles searcher = new PrintFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
