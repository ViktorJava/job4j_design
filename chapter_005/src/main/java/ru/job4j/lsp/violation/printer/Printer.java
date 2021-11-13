package ru.job4j.lsp.violation.printer;

/**
 * Модель данных принтер.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class Printer {
    private final String text;
    private final int paper;

    public Printer(String text, int paper) {
        this.text = text;
        this.paper = paper;
    }

    public String getText() {
        return text;
    }

    public int getPaper() {
        return paper;
    }
}
