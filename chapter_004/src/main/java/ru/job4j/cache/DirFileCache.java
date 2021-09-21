package ru.job4j.cache;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/21/2021
 */
public class DirFileCache extends AbstractCache<String, String> {
    //TODO Реализовать класс
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {

        return null;
    }
}
