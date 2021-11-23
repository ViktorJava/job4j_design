package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тесты парковки.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public class ManagerParkingTest {
    /**
     * Когда легковая паркуется на свою парковку.
     */
    @Test
    @Ignore
    public void whenPassengerCarParkingOK() {
        ManagerParking managerParking = new ManagerParking(1, 0);
        boolean rsl = managerParking.accept(new PassengerCar());
        assertTrue(rsl);
    }

    /**
     * Когда легковой нет места.
     */
    @Test
    @Ignore
    public void whenPassengerCarOnTruckParkingThenFalse() {
        ManagerParking managerParking = new ManagerParking(0, 1);
        boolean rsl = managerParking.accept(new PassengerCar());
        assertFalse(rsl);
    }

    /**
     * Когда грузовик паркуется на своей парковке.
     */
    @Test
    @Ignore
    public void whenTruckOnTruckParkingThenTrue() {
        ManagerParking managerParking = new ManagerParking(0, 1);
        boolean rsl = managerParking.accept(new Truck(2));
        assertTrue(rsl);
    }

    /**
     * Когда грузовик паркуется на парковке легковых машин.
     */
    @Test
    @Ignore
    public void whenTruckOnPassengerParkingThenTrue() {
        ManagerParking managerParking = new ManagerParking(2, 0);
        boolean rsl = managerParking.accept(new Truck(2));
        assertTrue(rsl);
    }

    /**
     * Когда грузовику нет места.
     */
    @Test
    @Ignore
    public void whenOnTruckParkingNoEnoughFreeSpace() {
        ManagerParking managerParking = new ManagerParking(1, 0);
        boolean rsl = managerParking.accept(new Truck(2));
        assertFalse(rsl);
    }
}
