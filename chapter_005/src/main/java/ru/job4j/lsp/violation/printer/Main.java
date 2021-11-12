package ru.job4j.lsp.violation.printer;

/**
 * Принтеры.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class Main {
    public static void main(String[] args) {
        IPrinter p = new Printer();
        p.printer(10);
        IPrinter ps = new PrinterStars();
        ps.printer(10);

    }
}
