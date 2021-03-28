package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 27.03.2021
 */
public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Path root = Paths.get("c:\\projects\\job4j_design\\chapter_002");
        List<Path> listPath = Search.search(root, p -> !p
                .toFile()
                .getName()
                .endsWith("xml"));
        List<File> listFile = new ArrayList<>();
        for (Path path: listPath) {
            listFile.add(path.toFile());
            System.out.println(path.toFile());
        }
        new Zip().packFiles(listFile, new File("zip.zip"));
    }
}
