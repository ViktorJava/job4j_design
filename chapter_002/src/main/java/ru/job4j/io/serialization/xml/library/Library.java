package ru.job4j.io.serialization.xml.library;

import java.util.Arrays;

/**
 * Класс Library описывает библиотеку книг, с полями:
 * quantity- количество книг, presence- наличие книг, book- член класса Book,
 * comments- впечатления о книге как таковой.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
public class Library {
    private final int quantity;
    private final boolean presence;
    private final Book book;
    private final String[] comments;

    public Library(int quantity, boolean presence, Book book, String... comments) {
        this.quantity = quantity;
        this.presence = presence;
        this.book = book;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Library{"
                + "quantity=" + quantity
                + ", presence=" + presence
                + ", book=" + book
                + ", comments=" + Arrays.toString(comments)
                + '}';
    }

    public static void main(String[] args) {
        Library library = new Library(100500, true, new
                Book(2020, "Herbert Schildt", "The complete reference"),
                "This is very good book", "...very heavy book.");
        System.out.println(library);
    }
}
