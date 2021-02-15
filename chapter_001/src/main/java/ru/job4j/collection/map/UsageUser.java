package ru.job4j.collection.map;

import java.util.*;

/**
 * Переопределить только hashCode [#438911]
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.02.2021
 */
public class UsageUser {
    public static void main(String[] args) {
        User user1 = new User("Viktor", 1,
                new GregorianCalendar(1979, Calendar.AUGUST, 25));
        User user2 = new User("Viktor", 1,
                new GregorianCalendar(1979, Calendar.AUGUST, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
