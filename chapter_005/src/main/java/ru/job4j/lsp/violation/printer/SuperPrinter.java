package ru.job4j.lsp.violation.printer;

/**
 * Класс супер-принтера.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class SuperPrinter extends SimplePrinter {
    /**
     * Конструктор супер-класса умеющий выводить на печать.
     *
     * @param printer Объект типа Printer.
     */
    public SuperPrinter(Printer printer) {
        super(printer);
    }

    /**
     * Метод установки новой задачи на печать. Нарушение контракта инвариантов
     * и в результате, принтер умеет печатать без бумаги.
     *
     * @param printer Объект типа Printer.
     */
    @Override
    public void newTask(Printer printer) {
        this.printer = printer;
        super.print();
    }
}
