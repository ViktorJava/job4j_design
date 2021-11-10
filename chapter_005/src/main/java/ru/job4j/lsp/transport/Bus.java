package ru.job4j.lsp.transport;

/**
 * Автобус потомок автотранспорта..
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class Bus extends AutoTransport {
    /**
     * Конструктор.
     *
     * @param fuel Заправка автобуса топливом.
     */
    public Bus(float fuel) {
        super(fuel);
    }

    /**
     * Метод движения автотранспорта.
     *
     * @param km Расстояние перемещения автобуса.
     */
    @Override
    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 5) { // условие усилено
            throw new IllegalArgumentException("Need more fuel!");
        }
        // other logic
    }
}
