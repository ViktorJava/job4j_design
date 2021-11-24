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
    private int passengerSpace;
    /**
     * Количество свободных мест для грузовых автомобилей.
     */
    private int truckSpace;
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
        if (car.getSize() == PassengerCar.SIZE && passengerSpace > 0) {
            passengerSpace--;
            passengerStorage.add(car);
            return true;
        } else if (car.getSize() > PassengerCar.SIZE && truckSpace > 0) {
            truckSpace--;
            truckStorage.add(car);
            return true;
        } else if (car.getSize() <= passengerSpace) {
            passengerSpace -= car.getSize();
            truckStorage.add(car);
            return true;
        }
        return false;
    }
}
