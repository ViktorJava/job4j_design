package ru.job4j.io;

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
//TODO пока даже шаблон написать не могу.
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        //Files.walkFileTree(start, new PrintFiles());
        search(start, p -> p.toFile().getName().endsWith("java")).forEach(System.out::println);
    }
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        PrintFiles searcher = new PrintFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
