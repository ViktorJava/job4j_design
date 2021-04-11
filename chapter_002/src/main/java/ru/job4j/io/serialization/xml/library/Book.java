package ru.job4j.io.serialization.xml.library;

/**
 * Класс Book описывает книгу, с полями:
 * year- год издательства, author- автор книги.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
public class Book {
    private final int year;
    private final String author;

    public Book(int year, String author) {
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{"
                + "year=" + year
                + ", author='" + author + '\''
                + '}';
    }
}
