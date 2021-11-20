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
    @Ignore
    @Test
    public void whenPassengerCarParkingOK() {
        ManagerParking managerParking = new ManagerParking(1, 0);
        boolean rsl = managerParking.accept(new PassengerCar());
        assertTrue(rsl);
    }

    @Test
    public void whenPassengerCarOnTruckParkingThenFalse() {
        ManagerParking managerParking = new ManagerParking(0, 1);
        boolean rsl = managerParking.accept(new PassengerCar());
        assertFalse(rsl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongTruckSize() {
        new ManagerParking(0, 0).accept(new Truck(1));
    }

    @Ignore
    @Test
    public void whenTruckParkingIsTrue() {
        ManagerParking managerParking = new ManagerParking(1, 1);
        boolean rsl = managerParking.accept(new Truck(2));
        assertTrue(rsl);
    }

    @Test
    public void whenTruckParkingIsFalse() {
        ManagerParking managerParking = new ManagerParking(1, 0);
        boolean rsl = managerParking.accept(new Truck(2));
        assertFalse(rsl);
    }

    @Test
    public void whenOnParkingNoEnoughFreeSpace() {
        ManagerParking managerParking = new ManagerParking(1, 1);
        boolean rsl = managerParking.accept(new Truck(3));
        assertFalse(rsl);
    }
}
