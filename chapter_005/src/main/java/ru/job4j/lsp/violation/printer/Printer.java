package ru.job4j.lsp.violation.printer;

/**
 * Класс принтера чисел.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class Printer implements IPrinter {
    /**
     * Метод печатает число на консоль.
     *
     * @param number Число.
     */
    @Override
    public void printer(int number) {
        System.out.println(number);
    }
}
