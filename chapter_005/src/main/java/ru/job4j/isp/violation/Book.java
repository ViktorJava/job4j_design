package ru.job4j.isp.violation;

/**
 * Не все книги характеризуются качеством печати или качеством бумаги.
 * Есть электронные книги, которым не актуальны эти два параметра.
 * А для библиотеки нужно знать UID присвоенный книге, чтобы её найти на полке
 * и, чтобы вести учёт книгам.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 21.11.2021
 */
public interface Book {
    String getMaterialBook();

    String getNumber();

    String getName();

    int count(String name);
}
