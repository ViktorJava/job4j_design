package ru.job4j.io.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * <h2>Симуляция терминала Linux.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 19.04.2021
 */
public class Shell {
    private String root = "";
    private final String delimiter = "/";
    private final List<String> listFirst = new ArrayList<>();
    private final List<String> listSecond = new ArrayList<>();

    /**
     * В потоке применяется фильтр "пустышка".
     * Без фильтра, при {@code path = "/user"}
     * в {@code ArrayList<String> list} попадёт "пустышка":
     * {@code ArrayList<String> list = {"","user"}}
     *
     * @param path Каталог.
     */
    public void cd(String path) {
        stream(path.split(delimiter))
                .filter(f -> !f.equals(""))
                .forEach(f -> this.parsing(f, path));

        if (listSecond.size() > 0) { //для тестового случая whenAbsolutePath.
            root = listSecond
                    .stream()
                    .collect(Collectors.joining(delimiter, delimiter, ""));
        } else {
            root = listFirst
                    .stream()
                    .collect(Collectors.joining(delimiter, delimiter, ""));
        }
    }

    /**
     * Метод парсит элементы строки каталога.
     * Вторым параметром метода, передаётся строка описывающая каталог.
     * Нужна только в том случае который тестирует в тесте whenAbsolutePath.
     *
     * @param element Составной элемент каталога без разделителя.
     * @param path    Строка описывающая каталог.
     */
    private void parsing(String element, String path) {
        if (!root.equals("") && path.startsWith(delimiter)) {
            listSecond.add(element); //для тестового случая whenAbsolutePath.
        } else if (element.equals("..")) {
            if (listFirst.size() >= 1) {
                listFirst.remove(listFirst.size() - 1);
            }
        } else {
            listFirst.add(element);
        }
    }

    public String pwd() {
        return root;
    }
}
