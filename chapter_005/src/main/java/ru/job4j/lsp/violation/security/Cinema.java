package ru.job4j.lsp.violation.security;

/**
 * Обычный кинотеатр.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class Cinema {
    int age;

    /**
     * Метод покупки билета в кино.
     * Ограничения по возрасту. Фильм только для взрослых.
     *
     * @param age Фактический возраст покупателя.
     */
    public void ticked(int age) {
        if (age >= 18) {
            System.out.println("Билет на порнуху куплен.");
        }
    }
}
