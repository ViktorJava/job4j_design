package ru.job4j.lsp.parking;

/**
 * Класс грузовых автомобилей.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public class Truck implements Car {
    private static final int TRUCK_SIZE = 1;

    /**
     * Размер грузового автомобиля.
     */
    private final int size;

    public Truck(int size) {
        if (size <= TRUCK_SIZE) {
            throw new IllegalArgumentException("Wrong truck size.");
        }
        this.size = size;
    }

    /**
     * Метод возвращает размер грузового автомобиля.
     *
     * @return Размер грузового автомобиля.
     */
    @Override
    public int getSize() {
        return size;
    }
}
