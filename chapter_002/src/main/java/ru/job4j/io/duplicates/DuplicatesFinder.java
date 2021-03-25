package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 23.03.2021
 */
public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("./"), new DuplicatesVisitor());
    }
}
