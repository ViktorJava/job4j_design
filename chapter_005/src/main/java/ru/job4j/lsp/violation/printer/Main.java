package ru.job4j.lsp.violation.printer;

/**
 * В этом классе можно проверить работу всех принтеров. Простой принтер с бумагой
 * отработает нормально. Без бумаги выбросит исключение.
 * <p>
 * Супер-принтер с бумагой отработает нормально. Без бумаги тоже отработает
 * по причине нарушения LSP контракта инвариантов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class Main {
    public static void main(String[] args) {
        SuperPrinter superPrinter = new SuperPrinter(
                new Printer("Супер-принтер с бумагой", 1));
        superPrinter.newTask(new Printer("Супер-принтер без бумаги", 0));
    }
}
