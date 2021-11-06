package ru.job4j.srp.violation;

/**
 * Нарушение принципов SRP.
 * <p>
 * Книга.
 * Добавляем бизнес-логику в модель, этим мы добавляем доп.ответственность.
 * Класс имеет более одной цели и соответственно более одной причины
 * для изменения.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 05.11.2021
 */
public class Book {
    private final String author;
    private final String name;
    private final String text;

    public Book(String author, String name, String text) {
        this.author = author;
        this.name = name;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    /**
     * Метод вывода на консоль текста книги.
     */
    void printtext() {
        System.out.println(text);
    }

    /**
     * Метод поиска слова в тексте книги.
     *
     * @param word Разыскиваемое слово.
     * @return true в случае, если слово найдено, иначе false.
     */
    boolean searchWordInText(String word) {
        return text.contains(word);
    }
}
