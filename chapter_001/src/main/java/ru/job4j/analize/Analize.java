package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h2>Статистика по коллекции.</h2>
 * Результат работы класса, сводиться к определению разницы между
 * начальным состояние объекта и измененным.
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
        Info info = new Info();
        Map<Integer, String> prevMap = new HashMap<>();
        for (User pUser: previous) {
            prevMap.put(pUser.id, pUser.name);
        }
        for (User cUser: current) {
            if (!prevMap.containsKey(cUser.id)) {
                info.added++;
            } else if (!cUser.name.equals(prevMap.get(cUser.id))) {
                info.changed++;
            }
        }
        info.deleted = previous.size() - current.size() + info.added;
        return info;
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
    }
}
