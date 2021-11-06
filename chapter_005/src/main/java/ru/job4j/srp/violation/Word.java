package ru.job4j.srp.violation;

import java.util.List;

/**
 * Нарушение принципов SRP.
 * <p>
 * Манипуляция текстом и вывод его на экран и в файл. Необходимо выделить
 * отдельную абстракцию для вывода текста.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 05.11.2021
 */
public interface Word {
    List<String> addText(String word);

    List<String> findAndDelete(String word);

    List<String> deleteWord(String word);

    void printText(List<String> text);

    void saveText(List<String> text);
}
