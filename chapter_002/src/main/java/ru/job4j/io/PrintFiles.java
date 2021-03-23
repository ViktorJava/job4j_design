package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Это специальный класс, в котором инкапсулируется вся логика обхода дерева файлов.
 * Поместим сюда всю логику поиска файлов по определённому предикату.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.03.2021
 */
public class PrintFiles implements FileVisitor<Path> {
    List<Path> paths = new ArrayList<>();
    Predicate<Path> condition;

    public PrintFiles(Predicate<Path> condition) {
        this.paths = new ArrayList<>();
        this.condition = condition;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            paths.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
