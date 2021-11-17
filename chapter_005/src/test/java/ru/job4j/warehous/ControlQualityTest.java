package ru.job4j.warehous;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 15.11.2021
 */
public class ControlQualityTest {
    @Test
    public void test() {
        List<Storage> storages = List.of(
                new Shop(),
                new Trash(),
                new Warehouse()
        );
//        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(storages);

        controlQuality.test(new Coffee("Jacobs", LocalDate.now().minusMonths(1), LocalDate.now().minusDays(1), 120, 0));
        controlQuality.test(new Coffee("Cake", LocalDate.now().minusMonths(1), LocalDate.now(), 120, 0));
    }
}