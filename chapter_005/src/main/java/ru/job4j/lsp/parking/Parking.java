package ru.job4j.lsp.parking;

/**
 * Интерфейс описывающий абстрактную парковку для автомобилей.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public interface Parking {
    /**
     * Метод принимает автомобиль на парковку.
     *
     * @param car Объект типа Car.
     * @return true в случае удачной парковки, иначе false.
     */
    boolean accept(Car car);
}
