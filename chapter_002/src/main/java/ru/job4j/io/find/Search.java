package ru.job4j.io.find;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 25.04.2021
 */
public class Search extends SimpleFileVisitor<Path> {
    List<Path> paths;
    Predicate<Path> condition;

    public Search(Predicate<Path> condition) {
        this.condition = condition;
        this.paths = new ArrayList<>();
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            paths.add(file);
        }
        return CONTINUE;
    }
}
