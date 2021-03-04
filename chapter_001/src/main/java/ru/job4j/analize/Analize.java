package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.03.2021
 */
public class Analize {
    /**
     * Метод проводит анализ входных данных.
     *
     * @param previous начальные данные
     * @param current  измененные данные.
     * @return Результаты анализа входных данных.
     */
    public Info diff(List<User> previous, List<User> current) {
        if (previous == null || current == null) {
            throw new NoSuchElementException();
        }
        HashMap<Integer, User> hashMap = new HashMap<>();
        //TODO : Написать анализ входных данных.
        return null;
    }

    /**
     * Модель данных User.
     */
    public static class User {
        int id;
        String name;

        /**
         * Конструктор класса User.
         *
         * @param id   Идентификатор пользователя.
         * @param name Имя пользователя.
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Класс Info содержит данные анализа.
     */
    public static class Info {
        int added;
        int changed;
        int deleted;

        /**
         * Конструктор класса Info.
         *
         * @param added   Сколько добавлено новых пользователей.
         * @param changed Сколько изменено пользователей.
         * @param deleted Сколько удалено пользователей.
         */
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}
