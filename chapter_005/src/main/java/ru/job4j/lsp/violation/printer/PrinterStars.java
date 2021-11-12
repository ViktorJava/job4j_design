package ru.job4j.lsp.violation.printer;

/**
 * Класс принтера звёздочек.
 * Намеренно унаследован от класса Printer.
 * В результате получаем не наследника принтера,
 * а класс с совершенно другим функционалом.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class PrinterStars extends Printer {
    /**
     * Метод печатает заданное количество звёзд.
     *
     * @param number Число.
     */
    @Override
    public void printer(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }
    }
}
