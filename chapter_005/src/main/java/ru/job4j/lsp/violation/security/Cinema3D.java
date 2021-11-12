package ru.job4j.lsp.violation.security;

/**
 * 3D кинотеатр.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
public class Cinema3D extends Cinema {

    /**
     * Метод покупки билета в кино.
     * Ослабление ограничений по возрасту.
     */
    public void ticked() {
        if (age < 18) {
            System.out.println("3D Билет куплен.");
        }
    }
}
