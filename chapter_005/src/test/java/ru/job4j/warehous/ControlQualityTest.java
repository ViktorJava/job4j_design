package ru.job4j.warehous;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 15.11.2021
 */
public class ControlQualityTest {
    /**
     * Ссылка на список хранилищ.
     */
    List<Storage> storageList;
    /**
     * Ссылка на объект контроля качества.
     */
    ControlQuality controlQuality;

    @Before
    public void setup() {
        storageList = List.of(
                new Shop(),
                new Trash(),
                new Warehouse()
        );
    }

    /**
     * Свежесть продукта израсходована на 103% = Trash.
     */
    @Test
    public void testTrash() {
        Food coffee = new Coffee("Jacobs", LocalDate.now().minusMonths(1),
                LocalDate.now().minusDays(1), 120, 0);
        controlQuality = new ControlQuality(storageList);
        controlQuality.test(coffee);
        List<Food> expected = storageList.get(1).get();
        assertThat(expected.get(0).getName(), is("Jacobs"));
    }

    /**
     * Свежесть продукта израсходована на 96% = Warehouse.
     */
    @Test
    public void testShopAndDiscount() {
        Food coffee = new Coffee("MacCoffee", LocalDate.now().minusMonths(1),
                LocalDate.now().plusDays(1), 100, 0);
        controlQuality = new ControlQuality(storageList);
        controlQuality.test(coffee);
        List<Food> expected = storageList.get(0).get();
        assertThat(expected.get(0).getDiscount(), is(25));
    }

    /**
     * Свежесть продукта израсходована на 3% = Warehouse.
     */
    @Test
    public void testWarehouse() {
        Food coffee = new Coffee("BestOfTheBest", LocalDate.now().minusDays(1),
                LocalDate.now().plusMonths(1), 300, 0);
        controlQuality = new ControlQuality(storageList);
        controlQuality.test(coffee);
        List<Food> expected = storageList.get(2).get();
        assertThat(expected.get(0).getName(), is("BestOfTheBest"));
    }
}
