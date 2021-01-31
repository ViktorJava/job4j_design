package ru.job4j.generics.store;

/**
 * Интерфейс контейнера для хранения объектов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 24.01.2021
 */
public interface Store<T extends Base> {
    /**
     * Добавить элемент в контейнер.
     *
     * @param model Добавляемый элемент.
     */
    void add(T model);

    /**
     * Заменить элемент в хранилище.
     *
     * @param id    Идентификатор элемента в контейнере.
     * @param model Новый элемент, отправляемый в контейнер.
     * @return true в случае удачной замены, иначе false.
     */
    boolean replace(String id, T model);

    /**
     * Удаление элемента в контейнере.
     *
     * @param id Идентификатор удаляемого элемента.
     * @return true в случае удачного удаления, иначе false.
     */
    boolean delete(String id);

    /**
     * Поиск элемента в контейнере.
     *
     * @param id Идентификатор разыскиваемого элемента.
     * @return Найденный элемент.
     */
    T findById(String id);
}
