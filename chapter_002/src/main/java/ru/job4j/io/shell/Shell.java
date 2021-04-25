package ru.job4j.io.shell;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <h2>Симуляция терминала Linux.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 19.04.2021
 */
public class Shell {
    private static final String DELIM = "/";
    private final Stack<String> stack = new Stack<>();

    public void cd(String path) {
        if (path.startsWith(DELIM)) {
            parseAbsolute(path);
        } else {
            parseRelative(path);
        }
    }

    /**
     * Метод парсит абсолютный путь.
     *
     * @param path Путь.
     */
    private void parseAbsolute(String path) {
        String[] elements = path.split(DELIM);
        if (!stack.isEmpty()) {
            stack.clear(); // чит код.
        }
        for (String el: elements) {
            stack.push(el);
        }
    }

    /**
     * Метод парсит относительный путь.
     *
     * @param path Путь.
     */
    private void parseRelative(String path) {
        String[] elements = path.split(DELIM);
        for (String el: elements) {
            if (el.equals("..")) {
                stack.pop();
            } else {
                stack.push(el);
            }
        }
    }

    /**
     * Метод возвращает текущий каталог.
     *
     * @return Каталог.
     */
    public String pwd() {
        if (stack.empty()) {
            return DELIM;
        }
        return stack.stream()
                    .filter(s->!s.equals("")) // no dummy!
                    .collect(Collectors.joining(DELIM, DELIM, ""));
    }
}
