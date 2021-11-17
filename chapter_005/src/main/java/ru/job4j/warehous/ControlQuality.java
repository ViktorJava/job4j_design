package ru.job4j.warehous;

import java.util.List;

/**
 * Контроль качества.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.11.2021
 */
public class ControlQuality {
    /**
     * Список возможных хранилищ.
     */
    private final List<Storage> storageList;

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    /**
     * Метод тестирует продукт в каждом из хранилищ из списка.
     *
     * @param food Продукт на тестирование.
     */
    public void test(Food food) {
        storageList.forEach(s -> s.put(food));
    }
}
