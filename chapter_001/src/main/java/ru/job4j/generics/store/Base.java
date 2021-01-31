package ru.job4j.generics.store;

/**
 * Базовая модель объекта хранимого в контейнере.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 24.01.2021
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Возвращает идентификатор объекта.
     *
     * @return Уникальный идентификатор.
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Base{" + "id='" + id + '\'' + '}';
    }
}
