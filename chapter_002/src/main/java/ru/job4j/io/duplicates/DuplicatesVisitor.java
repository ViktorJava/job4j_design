package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 23.03.2021
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> propertyAll = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file
                .toFile()
                .length(), file.getFileName().toString());
        if (propertyAll.contains(fileProperty)) {
            System.out.println(file.toAbsolutePath());
        } else {
            propertyAll.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}
