package ru.job4j.lsp.violation.printer;

/**
 * Класс простого принтера.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class SimplePrinter {
    protected Printer printer;

    /**
     * Конструктор принтера с возможностью вывода на печать.
     *
     * @param printer Объект типа Printer.
     */
    public SimplePrinter(Printer printer) {
        validate(printer);
        this.printer = printer;
        print();
    }

    /**
     * Метод установки новой задачи на печать.
     *
     * @param printer Объект типа Printer.
     */
    public void newTask(Printer printer) {
        validate(printer);
        this.printer = printer;
        print();
    }

    /**
     * Метод валидации принтера.
     *
     * @param printer Объект типа Printer.
     */
    private void validate(Printer printer) {
        if (printer.getPaper() <= 0) {
            throw new IllegalArgumentException("Paper not found!");
        }
    }

    /**
     * Метод вывода на печать.
     */
    public void print() {
        System.out.printf("text: %s; paper: %d %n",
                printer.getText(), printer.getPaper());
    }
}
