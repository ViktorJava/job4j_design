package ru.job4j.template;

import java.util.Map;

/**
 * Шаблонизатор. [#855]
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10/23/2021
 */
public interface Generator {
    String producer(String template, Map<String, String> arg);
}
