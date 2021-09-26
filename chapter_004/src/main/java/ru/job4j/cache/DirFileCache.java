package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Файловый класс.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/21/2021
 */
public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    /**
     * Конструктор принимает директорию с файлами для кэширования.
     *
     * @param cachingDir Директория расположения кэшируемых файлов.
     */
    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     * Метод загружает содержимое файла.
     *
     * @param key Имя файла.
     * @return Содержимое файла.
     */
    @Override
    protected String load(String key) {
        String result = null;
        try {
            result = Files.readString(Paths.get(cachingDir + key));
        } catch (IOException e) {
            System.out.printf("Ошибка загрузки файла: %s%n", key);
        }
        return result;
    }
}
