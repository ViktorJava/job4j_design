package ru.job4j.analize;

import java.util.*;

/**
 * Статистика по коллекции.
 *
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
        int add = 0;
        int change = 0;
        int del = 0;
        Map<Integer, String> prevMap = new HashMap<>();
        Map<Integer, String> curMap = new HashMap<>();
        for (User pUser: previous) {
            prevMap.put(pUser.id, pUser.name);
        }
        for (User cUser: current) {
            curMap.put(cUser.id, cUser.name);
            if (!prevMap.containsKey(cUser.id)) {
                add++;
            } else {
                if (!cUser.getName().equals(prevMap.get(cUser.getId()))) {
                    change++;
                }
            }
            //TODO : как считать del?!
            //del=
        }
        return new Info(add, change, del);
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

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    /**
     * Класс Info содержит данные анализа.
     */
    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
