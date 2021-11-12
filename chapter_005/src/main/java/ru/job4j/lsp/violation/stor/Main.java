package ru.job4j.lsp.violation.stor;

/**
 * Магазины.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class Main {
    public static void main(String[] args) {
        Stor stor = new SuperStor(4);
        stor.buy(234);
    }
}
