package ru.job4j.lsp.transport;

/**
 * Класс автотранспорта.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class AutoTransport {
    protected float fuel;

    /**
     * Конструктор.
     *
     * @param fuel Заправка топливом автотранспорта.
     */
    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    /**
     * Метод движения автотранспорта.
     *
     * @param km Расстояние перемещения автотранспорта.
     */
    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 0) { // <= предусловие
            throw new IllegalArgumentException("Need more fuel!");
        }
        // other logic
    }
}
