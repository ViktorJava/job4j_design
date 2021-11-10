package ru.job4j.lsp.transport;

/**
 * Первый контракт LSP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(3);
        bus.move(2);
    }
}
