package ru.job4j.generics.store;

/**
 * Реализация для пользователя.
 * Используем композицию объектов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 24.01.2021
 */
public class UserStore implements Store<User> {
    private final Store<User> store = new MemStore<>();

    /**
     * Добавление элемента в хранилище.
     *
     * @param model Добавляемый элемент.
     */
    @Override
    public void add(User model) {
        store.add(model);
    }

    /**
     * Замена элемента в хранилище.
     *
     * @param id    Идентификатор элемента в контейнере.
     * @param model Новый элемент, отправляемый в контейнер.
     * @return Метод возвращает true в случае удачной замены
     * элемента в хранилище, иначе false.
     */
    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    /**
     * Удаление элемента в хранилище.
     *
     * @param id Идентификатор удаляемого элемента.
     * @return Метод возвращает true в случае удачного удаления
     * элемента в хранилище, иначе false.
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * Поиск элемента в хранилище.
     *
     * @param id Идентификатор разыскиваемого элемента.
     * @return Метод возвращает найденный объект, иначе null.
     */
    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
