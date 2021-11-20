package ru.job4j.lsp.parking;

/**
 * Класс легковых автомобилей.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public class PassengerCar implements Car {
    private final int size = 1;

    /**
     * Метод возвращает размер легкового автомобиля.
     *
     * @return Размер легкового автомобиля.
     */
    @Override
    public int getSize() {
        return size;
    }
}
