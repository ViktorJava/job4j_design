package ru.job4j.generics.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Каркас универсального хранилища.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 24.01.2021
 */
public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    /**
     * Добавить элемент в хранилище.
     *
     * @param model Добавляемый элемент.
     */
    @Override
    public void add(T model) {
        mem.add(model);
    }

    /**
     * Заменить элемент в хранилище по идентификатору.
     *
     * @param id    Идентификатор элемента в контейнере.
     * @param model Новый элемент, отправляемый в контейнер.
     * @return true в случае удачной замены, иначе false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                mem.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление элемента из хранилища по id.
     *
     * @param id Идентификатор удаляемого элемента.
     * @return Возвращает true в случае удаления элемента, иначе false.
     */
    @Override
    public boolean delete(String id) {
        return mem.removeIf(e -> e.getId().equals(id));
    }

    /**
     * Поиск элемента в хранилище по идентификатору.
     *
     * @param id Идентификатор разыскиваемого элемента.
     * @return Объект найденного элемента.
     */
    @Override
    public T findById(String id) {
        return mem.stream()
                  .filter(e -> e.getId().equals(id))
                  .findFirst()
                  .orElse(null);
    }
}
