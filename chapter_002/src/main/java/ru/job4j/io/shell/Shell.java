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
    private List<String> list = new ArrayList<>();

    public void cd(String path) {
        stream(path.split("/"))
                .filter(f -> !f.equals(""))
                .forEach(this::parsing);
        root = list.stream().collect(Collectors.joining("/", "/", ""));
    }

    private void parsing(String s) {
        if (s.equals("..")) {
            if (list.size() >= 1) {
                list.remove(list.size() - 1);
            }
        } else {
            this.list.add(s);
        }
    }

    public String pwd() {
        return root;
    }
}
