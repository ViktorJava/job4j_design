package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс управляющий парковкой.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public class ManagerParking implements Parking {
    /**
     * Количество свободных мест для пассажирских автомобилей.
     */
    private final int passengerSpace;
    /**
     * Количество свободных мест для грузовых автомобилей.
     */
    private final int truckSpace;
    /**
     * Хранилище грузовых автомобилей.
     */
    private final List<Car> truckStorage;
    /**
     * Хранилище легковых автомобилей.
     */
    private final List<Car> passengerStorage;

    public ManagerParking(int passengerSpace, int truckSpace) {
        this.passengerSpace = passengerSpace;
        this.truckSpace = truckSpace;
        truckStorage = new ArrayList<>();
        passengerStorage = new ArrayList<>();
    }

    /**
     * Метод принимает автомобиль на парковку.
     *
     * @param car Объект типа Car.
     * @return true в случае удачной парковки, иначе false.
     */
    @Override
    public boolean accept(Car car) {
        return false;
    }
}